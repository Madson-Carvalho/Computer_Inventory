package com.computer.inventory;

import com.computer.inventory.server.ComputerInventoryServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComputerInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputerInventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner startComputerInventoryServer(ComputerInventoryServer server) {
        return args -> {
            ComputerInventoryServer.startServer();
        };
    }
}
