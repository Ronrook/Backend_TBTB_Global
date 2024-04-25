package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpecialtyRepository extends JpaRepository<Specialty, Integer> {
}
