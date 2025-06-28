package com.base64.gamesback.common.email.service.impl;

import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.common.email.dto.EmailRequest;
import com.base64.gamesback.common.email.dto.EmailWelcome;
import com.base64.gamesback.common.email.service.EmailDeliveryService;
import com.base64.gamesback.common.email.service.EmailTemplateService;
import com.base64.gamesback.common.email.service.EmailUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Year;

@Slf4j
@Service
public class EmailUserServiceImpl implements EmailUserService {

    private final EmailDeliveryService emailDeliveryService;
    private final EmailTemplateService emailTemplateService;

    public EmailUserServiceImpl(EmailDeliveryService emailDeliveryService, EmailTemplateService emailTemplateService) {
        this.emailDeliveryService = emailDeliveryService;
        this.emailTemplateService = emailTemplateService;
    }

    private void emailSend(String email, String subject, String body) {
        EmailRequest emailRequest = EmailRequest.create(email, subject, body);
        emailDeliveryService.send(emailRequest);
    }

    @Override
    public void sendCodeVerification(User user) {
        String body = emailTemplateService.getEmailTemplateByName("two_factor_authentication")
                .replaceAll("person_name", user.getPerson().getPersonName())
                .replace("verification_code_1", String.valueOf(user.getCodeVerification().charAt(0)))
                .replace("verification_code_2", String.valueOf(user.getCodeVerification().charAt(1)))
                .replace("verification_code_3", String.valueOf(user.getCodeVerification().charAt(2)))
                .replace("verification_code_4", String.valueOf(user.getCodeVerification().charAt(3)))
                .replace("verification_code_5", String.valueOf(user.getCodeVerification().charAt(4)))
                .replace("verification_code_6", String.valueOf(user.getCodeVerification().charAt(5)));
        body = body.replaceAll("current_year", String.valueOf(Year.now().getValue()));

        EmailRequest emailRequest = EmailRequest.create(user.getPerson().getPersonEmail(), "Tu código de verificación", body);
        emailDeliveryService.send(emailRequest);
    }

    @Override
    public void sendEmailWelcomeMessage(EmailWelcome emailWelcome) {
        String body = emailTemplateService.getEmailTemplateByName("welcome")
                .replace("person_name", emailWelcome.getRecipientName());
        EmailRequest emailRequest = EmailRequest.create(emailWelcome.getEmail(), "¡Bienvenido!", body);
        emailDeliveryService.send(emailRequest);
    }
}
