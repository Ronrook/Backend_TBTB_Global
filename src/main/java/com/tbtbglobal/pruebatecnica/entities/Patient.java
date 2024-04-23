package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private Integer patientId;


    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "diagnosis")
    private String diagnosis;

    // Getters and setters
}
