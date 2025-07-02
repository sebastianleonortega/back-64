package com.base64.gamesback.auth.user.service.impl;

import com.base64.gamesback.auth.user.dto.UpdatePassword;
import com.base64.gamesback.auth.user.dto.UserDto;
import com.base64.gamesback.auth.user.dto.UserUpdateRequest;
import com.base64.gamesback.auth.user.dto.projection.userData;
import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.auth.user.repository.UserRepository;
import com.base64.gamesback.auth.user.service.PersonService;
import com.base64.gamesback.auth.user.service.UserService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, PersonService personService ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.personService = personService;
    }

    @Override
    public userData getUserById(UUID userId) {
        return userRepository.getUserId(userId);
    }

    @Override
    public Boolean existUserByName(String userName) {
        return userRepository.existsUserByName(userName.toLowerCase(Locale.ROOT));
    }

    @Override
    public void registerUser(UserDto request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.create(
                request.getName().toLowerCase(Locale.ROOT),
                encodedPassword,
                false,
                null
        );
        personService.registerPerson(userRepository.save(user), request.getPerson());
    }

    @Override
    public void updateUser(UserUpdateRequest request, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No existe este usuario"));

        user.update(
                request.getName().toLowerCase(Locale.ROOT),
                request.getProfileImage()
                );

        personService.updatePerson(request.getPerson(), userRepository.save(user));
    }

    @Override
    public void updatePassword(UpdatePassword request, UUID userId) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No existe este usuario"));
        if (Objects.equals(request.getPassword(), request.getConfirmPassword())) {
            String encodedPassword = passwordEncoder.encode(request.getPassword());
            userRepository.updatePasswordById(userId, encodedPassword);
        }else {
            throw new ResourceNotFoundException("Las contraseñas no coinciden");
        }


    }

}
