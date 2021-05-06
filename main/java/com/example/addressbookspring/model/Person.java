package com.example.addressbookspring.model;


import com.example.addressbookspring.dto.PersonDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "address_book")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipInt;
    private long pNoInt;
    private String email;
    private String type;

    public Person() {}

    public Person(PersonDTO person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.city = person.getCity();
        this.state = person.getState();
        this.zipInt = person.getZipInt();
        this.pNoInt = person.getPNoInt();
        this.email = person.getEmail();
        this.type = person.getType();
    }

    public Person(int id, PersonDTO person) {
        this.id = id;
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.city = person.getCity();
        this.state = person.getState();
        this.zipInt = person.getZipInt();
        this.pNoInt = person.getPNoInt();
        this.email = person.getEmail();
        this.type = person.getType();
    }


}
