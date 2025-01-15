package com.bnb3.payload;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private long id;

    @Size(min=3)@NotBlank(message="name should be more than 3 characters")
    private String name;
@Email(message="enter valid email format")
    private String emailId;
@Size(min=10,max=10)@NotBlank(message="Number should be in10 digits")
    private String number;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getNumber() {
        return number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
