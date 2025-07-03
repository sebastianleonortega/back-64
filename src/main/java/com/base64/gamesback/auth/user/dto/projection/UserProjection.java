package com.base64.gamesback.auth.user.dto.projection;

public interface UserProjection {

    String getName();
    Boolean getAdministrator();
    String getProfileImage();
    String getFirstName();
    String getLastName();
    String getDocumentNumber();
    String getAddress();
    String getPhone();
    String getEmail();
}
