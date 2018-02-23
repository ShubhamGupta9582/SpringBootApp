package com.demo.pkg.commands;

import java.util.List;
import java.util.Set;

public class UserCommand
{
    private String name;
    private String email;
    private Double salary;

    private List<Integer> roleIds;

    private Set<String> roles;

    public UserCommand() {
    }

    public UserCommand(String name, String email, Double salary, List<Integer> roleIds) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.roleIds = roleIds;
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

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
