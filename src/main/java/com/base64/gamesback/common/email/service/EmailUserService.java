package com.base64.gamesback.common.email.service;

import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.common.email.dto.EmailWelcome;

public interface EmailUserService {

    void sendCodeVerification(User user);

    void sendEmailWelcomeMessage(EmailWelcome emailWelcome);

}
