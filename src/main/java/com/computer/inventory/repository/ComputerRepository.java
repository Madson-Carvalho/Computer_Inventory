package com.computer.inventory.repository;

import com.computer.inventory.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, UUID> {
}
