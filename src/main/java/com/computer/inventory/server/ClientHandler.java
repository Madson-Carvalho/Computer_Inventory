package com.computer.inventory.server;

import com.computer.inventory.model.Computer;
import com.computer.inventory.service.ComputerService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final ComputerService computerService;

    public ClientHandler(Socket socket, ComputerService computerService) {
        this.socket = socket;
        this.computerService = computerService;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            Computer computer = (Computer) in.readObject();
            System.out.println("Received inventory data from " + computer.getUserName());

            computerService.createComputer(computer);

            out.writeObject("Data received successfully");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
