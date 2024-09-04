package com.computer.inventory.server;

import com.computer.inventory.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ComputerInventoryServer {
    private static final int PORT = 5555;
    private ExecutorService pool = Executors.newFixedThreadPool(10);

    @Autowired
    private ComputerService computerService;

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server start on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Client connected: " + socket.getInetAddress());
                pool.execute(new ClientHandler(socket, computerService));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
