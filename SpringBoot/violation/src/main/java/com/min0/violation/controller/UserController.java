package com.min0.violation.controller;


import com.min0.violation.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController("violation/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/viewTicket")
//    public ResponseEntity<Ticket> viewTicket(@RequestBody ViolationInfo violationInfo) {
//
//    }

}
