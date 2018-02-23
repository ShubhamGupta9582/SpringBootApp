package com.demo.pkg.dtos;

import java.util.Set;

public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private Double salary;

    private Set<String> roles;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String email, Double salary, Set<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
