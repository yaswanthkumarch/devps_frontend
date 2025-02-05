package com.project.middleware.TimesheetModule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Exception handler for TimesheetNotFoundException
    @ExceptionHandler(TimesheetNotFoundException.class)
    public ResponseEntity<String> handleTimesheetNotFound(TimesheetNotFoundException ex) {  // Handle the custom exception when a timesheet is not found

        // Return HTTP status 404 (NOT_FOUND) with the exception message as the response body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Exception handler for any other generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {  // Handle any other general exceptions

        // Return HTTP status 500 (INTERNAL_SERVER_ERROR) with a custom error message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

}
