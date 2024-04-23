package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "patient_medication")
public class PatientMedication {
    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

}
