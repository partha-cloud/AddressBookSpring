package com.example.addressbookspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AddressBookController {
    @Autowired
    IAddressBookService addressBook;

    /**
     * API to add new person to DB
     * @param person
     * @return Added Person
     */
    @PostMapping("/addperson")
    public ResponseEntity<AddressResponseDTO> addPerson(@RequestBody PersonDTO person) {
        AddressResponseDTO addedPerson = addressBook.addPerson(person);
        return new ResponseEntity<>(addedPerson, HttpStatus.CREATED);
    }

    /**
     * API to read all contacts in DB
     * @return List of Person
     */
    @GetMapping("/all")
    public ResponseEntity<AddressResponseDTO> listPersons(){
        return addressBook.listPerson();
    }

    /**
     * API to find contact by ID
     * @param id
     * @return Person
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<AddressResponseDTO> findPerson(@PathVariable int id) {
        return new ResponseEntity<>(new AddressResponseDTO("The Contact for the given ID is", addressBook.findPerson(id)), HttpStatus.FOUND);
    }

    /**
     * API to delete contact from DB
     * @param contact ID
     */
    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable int id) {
        addressBook.deletePerson(id);
    }

    /**
     * API to update contact details
     * @param contact id
     * @param person
     * @return person data
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressResponseDTO> updateContact(@PathVariable int id, @RequestBody PersonDTO person) {
        return new ResponseEntity<AddressResponseDTO>(addressBook.updatePerson(id, person), HttpStatus.ACCEPTED);
    }

    /**
     * API to get all contacts who belong to a given city or state
     * @param search
     * @return Response entity consisting List of contacts
     */
    @GetMapping("cityorstate/{search}")
    public ResponseEntity<AddressResponseDTO> searchByCityOrState(@PathVariable String search){
        return new ResponseEntity<AddressResponseDTO>(
                new AddressResponseDTO("Here are the contacts to belong to the given city or state", addressBook.findByCityOrState(search)),
                HttpStatus.FOUND);
    }
}
}
