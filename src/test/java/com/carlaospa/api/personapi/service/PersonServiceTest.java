package com.carlaospa.api.personapi.service;

import com.carlaospa.api.personapi.dto.request.PersonDTO;
import com.carlaospa.api.personapi.dto.response.MessageResponseDTO;
import com.carlaospa.api.personapi.entity.Person;
import com.carlaospa.api.personapi.dto.mapper.PersonMapper;
import com.carlaospa.api.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.carlaospa.api.personapi.utils.PersonUtils.createFakeDTO;
import static com.carlaospa.api.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavePerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavePerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavePerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavePerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId){
        return MessageResponseDTO.builder()
                .message("Created person with ID " + savedPersonId)
                .build();
    }

}
