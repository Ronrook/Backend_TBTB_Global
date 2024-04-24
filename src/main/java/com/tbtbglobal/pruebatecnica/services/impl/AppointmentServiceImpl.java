package com.tbtbglobal.pruebatecnica.services.impl;

import com.tbtbglobal.pruebatecnica.converters.AppointmentConverter;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.entities.Appointment;
import com.tbtbglobal.pruebatecnica.exceptions.ResourceNotFoundException;
import com.tbtbglobal.pruebatecnica.repository.IAppointmentRepository;
import com.tbtbglobal.pruebatecnica.services.interfaces.IAppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;
    private final AppointmentConverter appointmentConverter;
    @Autowired
    private final ModelMapper modelMapper;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
        this.modelMapper = modelMapper;
    }


    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request) {
        Appointment appointment =  appointmentConverter.fromDto(request);
        appointmentRepository.save(appointment);
        return appointmentConverter.fromEntity(appointment);
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                .toList();

    }

    @Override
    public AppointmentResponseDTO getAppointmentById(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada."));
        return appointmentConverter.fromEntity(appointment);
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
