package com.example.lab7_20206442.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID")
    private Integer DeviceID;

    @Column(name = "DeviceName")
    private String DeviceName;

    @Column(name = "DeviceType")
    private String DeviceType;

    @Column(name = "Model")
    private String Model;

    @Column(name = "SerialNumber")
   private String SerialNumber;

    @Column(name = "SiteID")
     private Integer SiteID;


}
