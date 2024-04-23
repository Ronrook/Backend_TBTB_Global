package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
