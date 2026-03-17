package com.base64.gamesback.user.service;

import com.base64.gamesback.user.dto.PersonDto;
import com.base64.gamesback.user.dto.PersonUpdateRequest;
import com.base64.gamesback.user.entity.User;

public interface PersonService {

    Boolean existPersonByEmail(String personEmail);

    Boolean existPersonByDocument(String personDocument);

    void registerPerson(User user, PersonDto personDto);

    void updatePerson(PersonUpdateRequest request, User user);
}
