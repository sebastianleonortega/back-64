package com.base64.gamesback.common.email.service.impl;

import com.base64.gamesback.auth.auth.exception.AuthenticationFailedException;
import com.base64.gamesback.common.email.dto.EmailRequest;
import com.base64.gamesback.common.email.entity.Email;
import com.base64.gamesback.common.email.service.EmailDeliveryService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class EmailDeliveryServiceImpl implements EmailDeliveryService {

    private final EmailServiceImpl emailServiceImpl;
    private final JavaMailSender javaMailSender;

    public EmailDeliveryServiceImpl(EmailServiceImpl emailServiceImpl, JavaMailSender javaMailSender) {
        this.emailServiceImpl = emailServiceImpl;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void send(EmailRequest request) {
        Email email = Email.create(request.destination(), Arrays.toString(request.copy()), request.subject(), request.body());
        try {
            MimeMessage mimeMessage = generateMimeMessage(request.destination(), request.copy(), request.subject(), request.body(), request.attachedName(), request.attached());
            if (request.attachedName() != null && request.attached() != null) {
                email.addAttachedDocument(request.attachedName(), request.attached());
            }
            javaMailSender.send(mimeMessage);
            email.addStatus(true, null);
            if (Boolean.TRUE.equals(request.queue())) {
                emailServiceImpl.save(email);
            }
        } catch (Exception exception) {
            email.addStatus(false, exception.getMessage());
            if (Boolean.TRUE.equals(request.queue())) {
                emailServiceImpl.save(email);
            }
        }
    }

    private MimeMessage generateMimeMessage(String destination, String[] copy, String subject, String body, String attachedName, String attached) throws MessagingException, MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        mimeMessageHelper.setTo(destination);
        if (copy != null) {
            mimeMessageHelper.setCc(Arrays.toString(copy));
        }
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body, true);
        if (attachedName != null && attached != null) {
            mimeMessageHelper.addAttachment(attachedName, Objects.requireNonNull(generateFile(attachedName)));
        }
        return mimeMessage;
    }

    private File generateFile(String base64File) {
        try {
            File tempFile = new File("/tmp/" + UUID.randomUUID());
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            byte[] data = Base64.decodeBase64(base64File);
            fileOutputStream.write(data);
            fileOutputStream.close();
            return tempFile;
        } catch (IOException exception) {
            throw new AuthenticationFailedException("No se pudo generar el documento adjunto");
        }
    }
}
