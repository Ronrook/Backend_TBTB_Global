package com.tbtbglobal.pruebatecnica.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private int specialtyId;

    @Column(name = "specialty_name")
    private String specialtyName;

    // Getters and setters
}
