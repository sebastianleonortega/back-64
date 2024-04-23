package com.base64.gamesback.auth.user.service.impl;

import com.base64.gamesback.auth.user.dto.UserDto;
import com.base64.gamesback.auth.user.dto.UserUpdateRequest;
import com.base64.gamesback.auth.user.dto.projection.userData;
import com.base64.gamesback.auth.user.entity.User;
import com.base64.gamesback.auth.user.repository.UserRepository;
import com.base64.gamesback.auth.user.service.PersonService;
import com.base64.gamesback.auth.user.service.UserService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PersonService personService;

    public UserServiceImpl(UserRepository userRepository, PersonService personService) {
        this.userRepository = userRepository;
        this.personService = personService;
    }

    @Override
    public userData getUserById(UUID userId) {
        return userRepository.getUserId(userId);
    }

    @Override
    public Boolean existUserByName(String userName) {
        return userRepository.existsUserByUserName(userName.toLowerCase(Locale.ROOT));
    }

    @Override
    public void registerUser(UserDto request) {
        User user = User.create(
                request.getName().toLowerCase(Locale.ROOT),
                request.getPassword(),
                false,
                null
        );
        personService.registerPerson(userRepository.save(user), request.getPerson());

    }

    @Override
    public void updateUser(UserUpdateRequest request, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No existe el usuario que desea actualizar"));

        user.update(
                request.getUserName().toLowerCase(Locale.ROOT),
                request.getProfileImage()
                );

        personService.updatePerson(request.getPerson(), userRepository.save(user));
    }
}
