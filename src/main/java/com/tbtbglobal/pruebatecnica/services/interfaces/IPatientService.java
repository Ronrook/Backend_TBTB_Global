package com.tbtbglobal.pruebatecnica.services.interfaces;

import com.tbtbglobal.pruebatecnica.entities.Patient;

public interface IPatientService {

    Patient getPatientById(Integer patientId);
}
