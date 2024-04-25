package com.tbtbglobal.pruebatecnica.services.impl;

import com.tbtbglobal.pruebatecnica.entities.Patient;
import com.tbtbglobal.pruebatecnica.exceptions.ResourceNotFoundException;
import com.tbtbglobal.pruebatecnica.repository.IPatientRepository;
import com.tbtbglobal.pruebatecnica.services.interfaces.IPatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository patientRepository;

    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient getPatientById(Integer patientId) {

        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado."));


    }
}
