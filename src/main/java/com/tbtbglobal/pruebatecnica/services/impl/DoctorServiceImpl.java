package com.tbtbglobal.pruebatecnica.services.impl;

import com.tbtbglobal.pruebatecnica.entities.Doctor;
import com.tbtbglobal.pruebatecnica.exceptions.ResourceNotFoundException;
import com.tbtbglobal.pruebatecnica.repository.IDoctorRepository;
import com.tbtbglobal.pruebatecnica.services.interfaces.IDoctorService;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements IDoctorService {

    private final IDoctorRepository doctorRepository;

    public DoctorServiceImpl(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor getDoctorById(Integer doctorId) {

        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado."));
    }
}
