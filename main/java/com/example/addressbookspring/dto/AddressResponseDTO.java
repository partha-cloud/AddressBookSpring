package com.example.addressbookspring.dto;


import lombok.Getter;

@Getter
public class AddressResponseDTO {
    String message;
    Object obj;

    public AddressResponseDTO(String message, Object obj) {
        this.message = message;
        this.obj = obj;
    }

}

