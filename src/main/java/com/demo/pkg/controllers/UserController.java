package com.demo.pkg.controllers;

import com.demo.pkg.commands.UserCommand;
import com.demo.pkg.dtos.ResponseDTO;
import com.demo.pkg.dtos.UserDto;
import com.demo.pkg.exceptions.IdNotFoundException;
import com.demo.pkg.responsecode.ApiResponseCode;
import com.demo.pkg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        response.setCode(ApiResponseCode.SUCCESS_CODE);
        response.setMessage(ApiResponseCode.SUCCESS_MESSAGE);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseDTO getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ApiResponseCode.SUCCESS_CODE);
        responseDTO.setMessage(ApiResponseCode.SUCCESS_MESSAGE);
        responseDTO.setData(userDtos);
        return responseDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO getById(@PathVariable Integer id){
        UserDto userDto = userService.getById(id);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ApiResponseCode.SUCCESS_CODE);
        responseDTO.setMessage(ApiResponseCode.SUCCESS_MESSAGE);
        responseDTO.setData(userDto);
        return responseDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseDTO updateUser(@RequestBody UserCommand userCommand, @PathVariable Integer id){
        UserDto userDto = userService.updateUser(id, userCommand);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ApiResponseCode.SUCCESS_CODE);
        responseDTO.setData(userDto);
        responseDTO.setMessage(ApiResponseCode.SUCCESS_MESSAGE);
        return responseDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseDTO deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ApiResponseCode.SUCCESS_CODE);
        responseDTO.setMessage(ApiResponseCode.SUCCESS_MESSAGE);
        return responseDTO;
    }

    @RequestMapping( value = "/page", method = RequestMethod.GET)
    public List<UserDto> findByName(@RequestParam String name, @RequestParam Integer offset, @RequestParam Integer max){
        return userService.findByName(name, offset, max);
    }

}

