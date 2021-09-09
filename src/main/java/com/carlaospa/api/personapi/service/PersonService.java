package com.carlaospa.api.personapi.service;

import com.carlaospa.api.personapi.dto.MessageResponseDTO;
import com.carlaospa.api.personapi.entity.Person;
import com.carlaospa.api.personapi.repository.PersonREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonREpository personREpository;

    @Autowired
    public PersonService (PersonREpository personREpository){
        this.personREpository = personREpository;
    }

    public MessageResponseDTO createPerson( Person person){
        Person savedPerson = personREpository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
