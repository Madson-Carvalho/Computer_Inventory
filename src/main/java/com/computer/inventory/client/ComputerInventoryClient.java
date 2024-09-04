package com.computer.inventory.client;

import com.computer.inventory.model.Computer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.Socket;

public class ComputerInventoryClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Computer computer = new Computer();
            computer.setOsName(System.getProperty("os.name"));
            computer.setVersion(System.getProperty("os.version"));
            computer.setArchitecture(System.getProperty("os.arch"));
            computer.setUserName(System.getProperty("user.name"));
            computer.setUserHome(System.getProperty("user.home"));
            computer.setJavaVersion(System.getProperty("java.version"));
            computer.setTotalPhysicalMemory(getTotalPhysicalMemory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTotalPhysicalMemory() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        if (osBean instanceof com.sun.management.OperatingSystemMXBean sunOsBean) {
            long totalMemoryBytes = sunOsBean.getTotalMemorySize();
            return formatBytes(totalMemoryBytes);
        } else {
            throw new UnsupportedOperationException("Unable to retrieve memory size on this operating system.");
        }
    }

    private static String formatBytes(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = "KMGTPE".charAt(exp - 1) + ("iB");
        return String.format("%.1f %s", bytes / Math.pow(unit, exp), pre);
    }
}
