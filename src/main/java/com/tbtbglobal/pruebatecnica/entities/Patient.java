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
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends User{

    @Column(name = "diagnosis")
    private String diagnosis;

    // Other attributes of Patient
}
