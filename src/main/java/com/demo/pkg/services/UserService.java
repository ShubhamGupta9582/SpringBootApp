package com.demo.pkg.services;

import com.demo.pkg.commands.UserCommand;
import com.demo.pkg.dtos.UserDto;
import com.demo.pkg.entities.Role;
import com.demo.pkg.entities.User;
import com.demo.pkg.exceptions.MyNullPointerException;
import com.demo.pkg.repositories.RoleRepository;
import com.demo.pkg.repositories.UserRepository;
import com.demo.pkg.responsecode.ApiResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void addUser(UserCommand userCommand) {

        User user = new User();
        user.setEmail(userCommand.getEmail());
        user.setName(userCommand.getName());
        user.setSalary(userCommand.getSalary());

        Set<Role> roles = null;
        List<Integer> roleIds = userCommand.getRoleIds();

        if (roleIds != null) {
            roles = new HashSet<>();

            for (int roleid : roleIds) {
                Role role = roleRepository.findOne(roleid);
                if (role != null) {
                    roles.add(role);
                }
            }
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = (List<User>) userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSalary(user.getSalary());
            userDto.setEmail(user.getEmail());
            Set<String> roleNames = new HashSet<>();
            for(Role role : user.getRoles()){
                roleNames.add(role.getRole());
            }
            userDto.setRoles(roleNames);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public UserDto getById(Integer id) {
        User user = userRepository.findOne(id);
        if(user == null){
            throw new MyNullPointerException(ApiResponseCode.NULL_CODE, ApiResponseCode.NULL_MESSAGE);
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setSalary(user.getSalary());
        Set<String> roleNames = new HashSet<>();
        for(Role role : user.getRoles()){
            roleNames.add(role.getRole());
        }
        userDto.setRoles(roleNames);
        return userDto;
    }

    public UserDto updateUser(Integer id, UserCommand userCommand) {
        User fetchedUser = userRepository.findOne(id);
        List<Integer> roleId = null;
        if(userCommand.getName() != null){
            fetchedUser.setName(userCommand.getName());
        }
        if(userCommand.getEmail() != null){
            fetchedUser.setEmail(userCommand.getEmail());
        }
        if(userCommand.getSalary() != 0){
            fetchedUser.setSalary(userCommand.getSalary());
        }
        if(userCommand.getRoleIds() != roleId){
            Set<Role> roles = new HashSet<>();
            List<Integer> roleIds = userCommand.getRoleIds();

                for (int roleid : roleIds) {
                    Role role = roleRepository.findOne(roleid);
                    if (role != null) {
                        roles.add(role);
                    }
            }
            fetchedUser.setRoles(roles);
        }
        User user = userRepository.save(fetchedUser);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setSalary(user.getSalary());
        Set<String> roleNames = new HashSet<>();
        for(Role role : user.getRoles()){
            roleNames.add(role.getRole());
        }
        userDto.setRoles(roleNames);
        return userDto;
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    public List<UserDto> findByName(String name, Integer offset, Integer max){
        Pageable pageable = new PageRequest(offset, max);
        Page<User> page = userRepository.findByName(name, pageable);
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : page){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setSalary(user.getSalary());
            Set<String> roleNames = new HashSet<>();
            for(Role role : user.getRoles()){
                roleNames.add(role.getRole());
            }
            userDto.setRoles(roleNames);
            userDtos.add(userDto);
        }
        return userDtos;
    }
}

