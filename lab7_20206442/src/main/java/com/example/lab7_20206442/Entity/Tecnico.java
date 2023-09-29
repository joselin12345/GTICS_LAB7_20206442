package com.example.lab7_20206442.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "technician")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private Integer TechnicianID;

    @Column(name = "FirstName")
    @NotBlank
    @Size(min = 3, max = 100, message = "El nombre debe tener maximo 100 caracteres y minimo 3")
    private String FirstName;

    @Column(name = "LastName")
    @NotBlank
    @Size(min = 3, max = 100, message = "El apellido debe tener maximo 100 caracteres y minimo 3")
    private String LastName;

    @Column(name = "Dni")
    @NotBlank
    @Digits(integer = 8 ,fraction = 0,message = "Debe tener solo 8 digitos " )
    private String Dni;

    @Column(name = "Phone")
    @NotBlank
    @Digits(integer = 9,fraction = 0, message = "Debe tener solo 9 digitos")
    private String Phone;

    @Column(name = "Age")
    @Digits(integer = 10,fraction = 0)
    @Positive
    private Integer Age;

}
