package com.base64.gamesback.auth.user.service;


import com.base64.gamesback.auth.user.dto.UserDto;
import com.base64.gamesback.auth.user.dto.UserResponse;
import com.base64.gamesback.auth.user.dto.UserUpdateRequest;
import com.base64.gamesback.auth.user.dto.projection.userData;
import com.base64.gamesback.auth.user.entity.User;

import java.util.UUID;

public interface UserService {

    userData getUserById(UUID userId);

    Boolean existUserByName(String userName);

    void registerUser(UserDto request);

    void updateUser(UserUpdateRequest request, UUID userId);
}
