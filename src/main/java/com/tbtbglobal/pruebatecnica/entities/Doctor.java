package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctor_id")
public class Doctor extends User {

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    // Other attributes of  Doctor
}
