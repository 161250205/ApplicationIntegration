package com.example.demo.dao;

import com.example.demo.bean.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDAO extends JpaRepository<Ticket,String> {
}
