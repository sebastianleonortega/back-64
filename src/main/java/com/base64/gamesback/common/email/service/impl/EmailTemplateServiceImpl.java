package com.base64.gamesback.common.email.service.impl;

import com.base64.gamesback.common.email.entity.EmailTemplate;
import com.base64.gamesback.common.email.repository.EmailTemplateRepository;
import com.base64.gamesback.common.email.service.EmailTemplateService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

    private final EmailTemplateRepository emailTemplateRepository;

    @Value("${settings.application.name}")
    private String applicationName;

    @Value("${settings.url.front}")
    private String urlFrontEnd;


    public EmailTemplateServiceImpl(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    private String getBodyWithBasicContent(String body) {

        body = body.replace("domain", urlFrontEnd);
        body = body.replace("application_name", applicationName);

        return body;
    }

    @Override
    public String getEmailTemplateByName(String templateName) {
        EmailTemplate emailTemplate = emailTemplateRepository.getEmailTemplateByName(templateName).orElseThrow(()-> new RuntimeException("No email template found with name") );
        emailTemplate.replaceBody(getBodyWithBasicContent(emailTemplate.getBody()));
        return emailTemplate.getBody();
    }
}
