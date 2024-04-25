package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
