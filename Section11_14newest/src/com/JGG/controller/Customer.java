package com.JGG.controller;

import javax.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required and has to have at least 3 chars")
    @Size(min=3, message = "is required and has to have at least 3 chars")
    private String firstName;

    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    //154 min and max. 157 notnull and change from int to Integer
    @NotNull(message = "is required")
    @Min(value=0, message="must be a number between 0 and 10")
    @Max(value=10, message="must be a number between 0 and 10")
    private Integer freePasses;

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    //156

    @Pattern(regexp = "^[0-9]{5}$", message="only five digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}

