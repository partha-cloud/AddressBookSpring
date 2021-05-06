package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.AddressResponseDTO;
import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAddressBookService {

    AddressResponseDTO addPerson(PersonDTO person);

    ResponseEntity<AddressResponseDTO> listPerson();

    Person findPerson(int id);

    void deletePerson(int id);

    AddressResponseDTO updatePerson(int id, PersonDTO person);

    List<Person> findByCityOrState(String search);

}