package com.base64.gamesback.common.email.service.impl;

import com.base64.gamesback.commerce.commerce.dto.ActivateCommerceDto;
import com.base64.gamesback.common.email.dto.EmailRequest;
import com.base64.gamesback.common.email.service.EmailCommerceService;
import com.base64.gamesback.common.email.service.EmailDeliveryService;
import com.base64.gamesback.common.email.service.EmailTemplateService;
import org.springframework.stereotype.Service;

@Service
public class EmailCommerceServiceImpl implements EmailCommerceService {

    private final EmailDeliveryService emailDeliveryService;
    private final EmailTemplateService emailTemplateService;


    public EmailCommerceServiceImpl(EmailDeliveryService emailDeliveryService , EmailTemplateService emailTemplateService) {
        this.emailDeliveryService = emailDeliveryService;
        this.emailTemplateService = emailTemplateService;
    }

    @Override
    public void sendEmailActivation(ActivateCommerceDto activateCommerceDto) {
        String body = emailTemplateService.getEmailTemplateByName("activate_commerce")
                .replace("name_commerce", activateCommerceDto.getName());
        EmailRequest emailRequest = EmailRequest.create(activateCommerceDto.getEmail(), "Activa tu comercio", body);
        emailDeliveryService.send(emailRequest);
    }
}
