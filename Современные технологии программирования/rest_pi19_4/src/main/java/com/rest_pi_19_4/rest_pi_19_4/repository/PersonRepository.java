package com.rest_pi_19_4.rest_pi_19_4.repository;

import com.rest_pi_19_4.rest_pi_19_4.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
