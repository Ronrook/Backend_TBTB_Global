package com.tbtbglobal.pruebatecnica.converters;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.entities.Appointment;
import com.tbtbglobal.pruebatecnica.services.interfaces.IDoctorService;
import com.tbtbglobal.pruebatecnica.services.interfaces.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class AppointmentConverter {

    private final IDoctorService doctorService;

    private final IPatientService patientService;
    @Autowired
    private final ModelMapper modelMapper;

    public AppointmentConverter(IDoctorService doctorService, IPatientService patientService, ModelMapper modelMapper) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.modelMapper = modelMapper;
    }

    public AppointmentResponseDTO fromEntity(Appointment appointment) {
        return  modelMapper.map(appointment, AppointmentResponseDTO.class);
    }
    public Appointment fromDto(AppointmentRequestDTO dto) {
        Appointment appointment = modelMapper.map(dto, Appointment.class);
        appointment.setDoctor(doctorService.getDoctorById(dto.getDoctorId()));
        appointment.setPatient(patientService.getPatientById(dto.getPatientId()));
        return appointment;
    }

    public List<AppointmentResponseDTO> fromEntity(List<Appointment> appointmentsList){
        if( appointmentsList == null) return Collections.emptyList();
        return appointmentsList.stream().map(this::fromEntity).toList();
    }
}
