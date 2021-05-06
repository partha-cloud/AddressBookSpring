package com.example.addressbookspring.repository;

import com.example.addressbookspring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressBookRepo extends JpaRepository<Person, Integer> {

    List<Person> findByCityOrState(String search);
}