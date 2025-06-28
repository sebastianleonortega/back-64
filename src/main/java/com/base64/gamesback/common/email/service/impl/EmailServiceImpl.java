package com.base64.gamesback.common.email.service.impl;

import com.base64.gamesback.common.email.entity.Email;
import com.base64.gamesback.common.email.repository.EmailRepository;
import com.base64.gamesback.common.email.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }
}
