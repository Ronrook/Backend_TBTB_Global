package com.tbtbglobal.pruebatecnica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private Integer medicationId;

    @Column(name = "medication_name")
    private String medicationName;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "administration_route")
    private String administrationRoute;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "indications")
    private String indications;

    @Column(name = "contraindications")
    private String contraindications;

    @Column(name = "sideEffects")
    private String sideEffects;

    @Column(name = "storage_instructions")
    private String storageInstructions;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToMany(mappedBy = "medications")
    private List<Patient> patients;

}