package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicationRepository extends JpaRepository<Medication, Integer> {
}
