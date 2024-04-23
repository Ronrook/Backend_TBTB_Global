package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
