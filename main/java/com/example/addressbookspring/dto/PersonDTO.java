package com.example.addressbookspring.dto;

import lombok.Data;
import org.intellij.lang.annotations.Pattern;

@Data
public class PersonDTO {
    @NotEmpty
    @Pattern(regexp = "[A-Z]{1}+[a-z]{2,}", message = "First Name is Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "[A-Z]{1}+[a-z]{2,}", message = "Last Name is Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")
    private String lastName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;
    @NotEmpty(message = "City Connot be empty")
    private String city;
    @NotEmpty(message = "State Connot be empty")
    private String state;

    @NotNull(message = "Zip Code cannot be empty")
    private int zipInt;
    @NotNull(message = "Phone Number cannot be empty")
    private long pNoInt;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty(message = "Address Book type cannot be empty")
    private String type;


}
