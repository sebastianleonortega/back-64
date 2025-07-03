package com.base64.gamesback.auth.user.service;


import com.base64.gamesback.auth.user.dto.UpdatePassword;
import com.base64.gamesback.auth.user.dto.UserDto;
import com.base64.gamesback.auth.user.dto.UserUpdateRequest;
import com.base64.gamesback.auth.user.dto.projection.UserProjection;

import java.util.UUID;

public interface UserService {

    UserProjection getUserById(UUID userId);

    Boolean existUserByName(String userName);

    void registerUser(UserDto request);

    void updateUser(UserUpdateRequest request, UUID userId);

    void updatePassword(UpdatePassword request, UUID userId);
}
