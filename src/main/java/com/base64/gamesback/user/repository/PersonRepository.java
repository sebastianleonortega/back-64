package com.base64.gamesback.user.repository;

import com.base64.gamesback.user.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Boolean existsPersonByEmail(String personEmail);

    Boolean existsPersonByDocumentNumber(String personDocument);
}
