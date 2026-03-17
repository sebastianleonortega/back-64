package com.base64.gamesback.authorization.auth.service;

import com.base64.gamesback.authorization.auth.dto.LoginRequest;
import com.base64.gamesback.authorization.auth.dto.LoginResponse;
import com.base64.gamesback.user.entity.User;
import com.base64.gamesback.common.email.dto.EmailWelcome;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    void sendCodeVerification(User user);

    void sendMessageWelcome(EmailWelcome emailWelcome);
}
