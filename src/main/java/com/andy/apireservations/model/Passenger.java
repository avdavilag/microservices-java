package com.andy.apireservations.model;

import java.time.LocalDate;
import java.util.Date;

public class Passenger {

    private Long id;
    private String FirstName;
    private String lastName;
    private String documentType;
    private String DocumentNumber;
    private LocalDate birthday;

    public Passenger() {
    }


    public Passenger(Long id, String firstName, String lastName, String documentType, String documentNumber, LocalDate birthday) {
        this.id = id;
        FirstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        DocumentNumber = documentNumber;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
