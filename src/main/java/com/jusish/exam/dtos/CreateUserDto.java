package com.jusish.exam.dtos;

import com.jusish.exam.classes.Address;
import com.jusish.exam.enums.URole;

public class CreateUserDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public URole getRole() {
        return role;
    }

    public void setRole(URole role) {
        this.role = role;
    }

    private String name;
    private String email;
    private String password;
    private URole role;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
