package com.tbtbglobal.pruebatecnica.services.impl;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.entities.Appointment;
import com.tbtbglobal.pruebatecnica.repository.IAppointmentRepository;
import com.tbtbglobal.pruebatecnica.services.interfaces.IAppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;


    @Autowired
    private final ModelMapper modelMapper;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        return null;
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(note -> modelMapper.map(note, AppointmentResponseDTO.class))
                .toList();

    }

    @Override
    public AppointmentResponseDTO getAppointmentById(Integer appointmentId) {
        return null;
    }

    @Override
    public AppointmentResponseDTO updateAppointment(Integer appointmentId, AppointmentRequestDTO updatedAppointment) {
        return null;
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {

    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByDoctorId(Integer employeeId) {
        return null;
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatientId(Integer customerId) {
        return null;
    }
}
