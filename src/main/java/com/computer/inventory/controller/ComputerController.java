package com.computer.inventory.controller;

import com.computer.inventory.model.Computer;
import com.computer.inventory.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/computers")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @PostMapping("/create")
    public ResponseEntity<Computer> createComputer(@RequestBody Computer computer) {
        return ResponseEntity.ok(computerService.createComputer(computer));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Computer>> findAllComputers() {
        return ResponseEntity.ok(computerService.findAllComputers());
    }

    @GetMapping("/find-computer-by-id/{id}")
    public ResponseEntity<Optional<Computer>> findComputerById(@RequestParam UUID id) {
        return ResponseEntity.ok(computerService.findComputerById(id));
    }
}
