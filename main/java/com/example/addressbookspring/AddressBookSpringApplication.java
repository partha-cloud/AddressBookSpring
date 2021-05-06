package com.example.addressbookspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@EnableSwagger2
public class AddressBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
        log.warn("Application Started");
    }

