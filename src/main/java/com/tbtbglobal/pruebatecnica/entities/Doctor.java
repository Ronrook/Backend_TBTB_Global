package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private Integer doctorId;

    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}
