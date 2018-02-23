package com.demo.pkg.controllers;

import com.demo.pkg.commands.RoleCommand;
import com.demo.pkg.dtos.RoleDto;
import com.demo.pkg.entities.Role;
import com.demo.pkg.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void addRole(@RequestBody RoleCommand roleCommand){
        roleService.addRole(roleCommand);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RoleDto getById(@PathVariable Integer id){
        return roleService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateRole(@RequestBody Role role, @PathVariable long id){
        roleService.updateRole(id, role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteRole(@PathVariable Integer id){
        roleService.deleteRole(id);
    }
}
