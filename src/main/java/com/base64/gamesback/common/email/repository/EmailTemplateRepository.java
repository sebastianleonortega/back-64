package com.base64.gamesback.common.email.repository;

import com.base64.gamesback.common.email.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, String> {

    Optional<EmailTemplate> getEmailTemplateByName(String TemplateName);
}
