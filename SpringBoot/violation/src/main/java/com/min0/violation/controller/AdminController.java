package com.min0.violation.controller;

import com.min0.violation.model.Ticket;
import com.min0.violation.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        log.debug("Entering addTicket():: AdminController");
        if(ticket == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        log.debug("Exiting addTicket():: AdminController");
        return new ResponseEntity<>(adminService.addTicket(ticket), HttpStatus.CREATED);
    }
}
