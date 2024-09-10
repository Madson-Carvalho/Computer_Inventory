package com.computer.inventory.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Computer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private UUID computerId;

    private String osName;
    private String version;
    private String architecture;
    private String userName;
    private String userHome;
    private String javaVersion;
    private String totalPhysicalMemory;

    public UUID getComputerId() {
        return computerId;
    }

    public void setComputerId(UUID computerId) {
        this.computerId = computerId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }

    public void setTotalPhysicalMemory(String totalPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
    }
}
