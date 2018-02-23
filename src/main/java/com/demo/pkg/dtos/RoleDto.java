package com.demo.pkg.dtos;

public class RoleDto {

    private Integer id;
    private String role;

    public RoleDto() {
    }

    public RoleDto(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
