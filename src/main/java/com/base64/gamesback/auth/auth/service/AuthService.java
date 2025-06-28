package com.base64.gamesback.auth.auth.service;

import com.base64.gamesback.auth.auth.dto.LoginRequest;
import com.base64.gamesback.auth.auth.dto.LoginResponse;
import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.common.email.dto.EmailWelcome;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    void sendCodeVerification(User user);

    void sendMessageWelcome(EmailWelcome emailWelcome);
}
