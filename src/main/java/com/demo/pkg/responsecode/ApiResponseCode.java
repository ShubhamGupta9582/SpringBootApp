package com.demo.pkg.responsecode;

public interface ApiResponseCode {

    Integer SUCCESS_CODE = 0;
    String SUCCESS_MESSAGE = "SUCCESS";
    Integer ERROR_CODE = 1;
    String ERROR_MESSAGE = "ERROR";
    Integer BAD_REQUEST_CODE = 2;
    String BAD_REQUEST_MESSAGE = "BAD_REQUEST";
    Integer NOT_FOUND_CODE = 6;
    String NOT_FOUND_MESSAGE = "NOT_FOUND";
    Integer NULL_CODE = 7;
    String NULL_MESSAGE = "Null Pointer Exception occurred";
}
