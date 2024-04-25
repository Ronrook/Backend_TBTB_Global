package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctor_id")
public class Doctor extends User {

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    // Other attributes of  Doctor
}
