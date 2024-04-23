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
