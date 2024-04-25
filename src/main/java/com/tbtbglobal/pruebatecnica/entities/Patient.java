package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends User{

    @Column(name = "diagnosis")
    private String diagnosis;


    @JoinTable(
            name = "rel_patients_medications",
            joinColumns = @JoinColumn(name = "patient_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="medication_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
   private List<Medication> medications;

    // Other attributes of Patient
}
