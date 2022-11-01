package com.min0.violation.controller;


import com.min0.violation.model.Ticket;
import com.min0.violation.model.ViolationInfo;
import com.min0.violation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("violation/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/viewTicket")
    public ResponseEntity<Ticket> viewTicket(@RequestBody ViolationInfo violationInfo) {
        return new ResponseEntity<>(userService.viewTicket(violationInfo.getNoticeNumber()), HttpStatus.OK);
    }

}
