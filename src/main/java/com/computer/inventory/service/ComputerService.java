package com.computer.inventory.service;

import com.computer.inventory.model.Computer;
import com.computer.inventory.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public Computer createComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public List<Computer> findAllComputers() {
        return computerRepository.findAll();
    }

    public Optional<Computer> findComputerById(UUID id) {
        return computerRepository.findById(id);
    }
}
