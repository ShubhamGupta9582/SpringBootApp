package com.demo.pkg.exceptions;

import com.demo.pkg.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseDTO> idNotFound(IdNotFoundException ex){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ex.getCode());
        responseDTO.setData(null);
        responseDTO.setMessage(ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MyNullPointerException.class)
    public ResponseEntity<ResponseDTO> nullPointerException(MyNullPointerException ex){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ex.getCode());
        responseDTO.setData(null);
        responseDTO.setMessage(ex.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
