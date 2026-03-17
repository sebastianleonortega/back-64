package com.base64.gamesback.user.service.impl;

import com.base64.gamesback.user.dto.PersonDto;
import com.base64.gamesback.user.dto.PersonUpdateRequest;
import com.base64.gamesback.user.entity.Person;
import com.base64.gamesback.user.entity.User;
import com.base64.gamesback.user.repository.PersonRepository;
import com.base64.gamesback.user.service.PersonService;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Boolean existPersonByEmail(String personEmail) {
        return personRepository.existsPersonByEmail(personEmail.toLowerCase(Locale.ROOT));
    }

    @Override
    public Boolean existPersonByDocument(String personDocument) {
        return personRepository.existsPersonByDocumentNumber(personDocument.toLowerCase(Locale.ROOT));
    }

    @Override
    public void registerPerson(User user, PersonDto request) {
       Person person = Person.create(
               request.getFirstName(),
               request.getLastname(),
               request.getDocumentNumber(),
               request.getAddress(),
               request.getPhone(),
               request.getEmail().toLowerCase(Locale.ROOT)
       );
        person.addUser(user);
        personRepository.save(person);

    }

    @Override
    public void updatePerson(PersonUpdateRequest request, User user ) {
        Person person = personRepository.findById(user.getPerson().getPersonId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        person.update(
                request.getFirstName(),
                request.getLastName(),
                request.getDocumentNumber(),
                request.getAddress(),
                request.getPhone(),
                request.getEmail()
        );
        personRepository.save(person);
    }
}
