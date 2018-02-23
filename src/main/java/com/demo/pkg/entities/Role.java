package com.demo.pkg.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;
    private String role;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(String role){
        this.role = role;
    }

    public Role(String role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
