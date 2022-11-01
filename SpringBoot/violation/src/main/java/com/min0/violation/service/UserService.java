package com.min0.violation.service;

import com.min0.violation.model.Ticket;
import com.min0.violation.repository.ViolationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService {

    @Autowired
    ViolationRepository violationRepository;

    public Ticket viewTicket(Long id) {
        return violationRepository.getReferenceById(id);
    }


}
