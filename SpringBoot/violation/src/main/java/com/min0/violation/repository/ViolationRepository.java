package com.min0.violation.repository;


import com.min0.violation.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRepository extends JpaRepository<Ticket, Long> {
}
