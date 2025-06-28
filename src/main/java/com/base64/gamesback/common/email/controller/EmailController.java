package com.base64.gamesback.common.email.controller;

import com.base64.gamesback.common.email.dto.EmailWelcome;
import com.base64.gamesback.common.email.service.EmailUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notifications")
public class EmailController {

    private final EmailUserService emailUserService;

    public EmailController(EmailUserService emailUserService) {
        this.emailUserService = emailUserService;
    }

    @PostMapping("/welcome-email")
    @Operation(description = "send email welcome" )
    @ApiResponse(responseCode = "200", description = "Email sent successfully")
    public ResponseEntity<HttpStatus> welcome(@Valid @RequestBody EmailWelcome emailWelcome){
        emailUserService.sendEmailWelcomeMessage(emailWelcome);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
