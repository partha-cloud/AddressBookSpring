package com.example.addressbookspring.service;

import com.example.addressbookspring.AddressBookException;
import com.example.addressbookspring.dto.AddressResponseDTO;
import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.model.Person;
import com.example.addressbookspring.repository.IAddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    /**
     * Object to repository interface
     */
    @Autowired
    IAddressBookRepo addressBookRepo;

    /**
     * ADD new person to Database
     * @param person DTO
     * @return addressbook response DTO containing person details and a message
     */
    @Override
    public AddressResponseDTO addPerson(PersonDTO person) {
        Person contact = new Person(person);
        return new AddressResponseDTO("Contact Added Successfully", addressBookRepo.save(contact));
    }

    /**
     * List all the persons in the database
     * @return response entity of addressbook response dto
     */
    @Override
    public ResponseEntity<AddressResponseDTO> listPerson() {
        List<Person> list =  addressBookRepo.findAll();
        return new ResponseEntity<>(new AddressResponseDTO("Here are all the contacts in the DB", list), HttpStatus.OK);
    }

    /**
     * Find a contact based on the given id
     * @param id
     * @return person data
     */
    @Override
    public Person findPerson(int id) {
        return addressBookRepo.findById(id).orElseThrow(()-> new AddressBookException(exceptionType.CONTACT_NOT_FOUND, "Contact not found for the given ID"));
    }

    /**
     * delete a person data from database
     * @param contact id
     */
    @Override
    public void deletePerson(int id) {
        addressBookRepo.deleteById(id);
    }

    /**
     * Update a contact details
     * @param contact id and person DTO
     * @return updated details of the person in addressbook response DTO
     */
    @Override
    public AddressResponseDTO updatePerson(int id, PersonDTO person) {
        Person contact = new Person(id, person);
        return new AddressResponseDTO("Here are the Updated Details for the given ID", addressBookRepo.save(contact));
    }

    /**
     * Find a contact who belongs to either a city or state given
     * @param name of either a city or a state
     * @return list of persons
     */
    @Override
    public List<Person> findByCityOrState(String search) {
        return addressBookRepo.findByCityOrState(search);
    }

}