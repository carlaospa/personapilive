package com.carlaospa.api.personapi.repository;

import com.carlaospa.api.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonREpository extends JpaRepository<Person, Long> {

}
