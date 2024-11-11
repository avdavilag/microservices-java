package com.andy.apireservations.DTO;

import java.util.Date;

public class PassangerDTO {

    private String Name;
    private String lastName;
    private String documentType;
    private Date birthday;

    public PassangerDTO(String Name, String lastName, String documentType, Date birthday) {
        this.Name = Name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.birthday = birthday;
    }

    public PassangerDTO() {
    }
    // Getters
    public String getName() {
        return Name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Date getBirthday() {
        return birthday;
    }

    // Setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
