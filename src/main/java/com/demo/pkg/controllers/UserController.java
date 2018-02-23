package com.demo.pkg.controllers;

import com.demo.pkg.commands.UserCommand;
import com.demo.pkg.dtos.ResponseDTO;
import com.demo.pkg.dtos.UserDto;
import com.demo.pkg.entities.User;
import com.demo.pkg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseDTO addUser(@RequestBody UserCommand userCommand){
        System.out.println("method call from react App");
        userService.addUser(userCommand);

        ResponseDTO response = new ResponseDTO();
        response.setCode(0);
        response.setMessage("User Created Successfully.");
        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateUser(@RequestBody User user, @PathVariable Integer id){
        userService.updateUser(id, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @RequestMapping( value = "/page", method = RequestMethod.GET)
    public List<UserDto> findByName(@RequestParam String name, @RequestParam Integer offset, @RequestParam Integer max){
        return userService.findByName(name, offset, max);
    }

}

