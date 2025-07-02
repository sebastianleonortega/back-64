package com.base64.gamesback.auth.auth.service.impl;

import com.base64.gamesback.auth.auth.dto.LoginRequest;
import com.base64.gamesback.auth.auth.dto.LoginResponse;
import com.base64.gamesback.auth.auth.service.AuthService;
import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.auth.user.repository.UserRepository;
import com.base64.gamesback.common.email.dto.EmailWelcome;
import com.base64.gamesback.common.email.service.EmailUserService;
import com.base64.gamesback.common.exception_handler.AccessDeniedException;
import com.base64.gamesback.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Locale;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final EmailUserService emailUserService;
    private final PasswordEncoder passwordEncoder;


    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, EmailUserService emailUserService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.emailUserService = emailUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
       User user = userRepository.getUserByName(request.getName().toLowerCase(Locale.ROOT));

       if(user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())){
           String token = jwtUtil.create(String.valueOf(user.getUserId()), user.getPerson().getEmail());
//           sendCodeVerification(user);
           return LoginResponse.create(user.getUserId(), user.getProfileImage(), user.isAdministrator(), user.getPerson().getFirstName(), user.getPerson().getLastName(), token);
       }else {
           throw new AccessDeniedException("Credenciales incrrectas");
       }
    }

    @Override
    public void sendCodeVerification(User user) {
        SecureRandom random = new SecureRandom();
        int numberRandom = random.nextInt(999999);
        String code = String.format("%06d", numberRandom);

        user.addCodeVerification(code);
        userRepository.save(user);
        emailUserService.sendCodeVerification(user);
    }

    @Override
    public void sendMessageWelcome(EmailWelcome emailWelcome) {
        emailUserService.sendEmailWelcomeMessage(emailWelcome);

    }

}
