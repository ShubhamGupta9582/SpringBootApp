package com.demo.pkg.services;

import com.demo.pkg.commands.RoleCommand;
import com.demo.pkg.dtos.RoleDto;
import com.demo.pkg.entities.Role;
import com.demo.pkg.repositories.RoleRepository;
import com.demo.pkg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public void addRole(RoleCommand roleCommand){
        Role role = new Role();
        role.setRole(roleCommand.getRole());
        roleRepository.save(role);
    }

    public List<RoleDto> getAllRoles(){
        List<Role> roles = (List<Role>)roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        for(Role role : roles){
            RoleDto roleDto = new RoleDto();
            roleDto.setId(role.getId());
            roleDto.setRole(role.getRole());
            roleDtos.add(roleDto);
        }
        return roleDtos;
    }

    public RoleDto getById(Integer id){
        Role role = roleRepository.findOne(id);
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        return roleDto;
    }

    public void updateRole(long id, Role role){
        roleRepository.save(role);
    }

    public void deleteRole(Integer id){
        roleRepository.delete(id);
    }
}
