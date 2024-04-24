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

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
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
        return appointmentConverter.fromEntity(appointments);

    }

    @Override
    public AppointmentResponseDTO getAppointmentById(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada."));
        return appointmentConverter.fromEntity(appointment);
    }

    @Override
    public AppointmentResponseDTO updateAppointment(Integer appointmentId, AppointmentRequestDTO appointmentDTO) {
        // validar si existe cita a actualizar
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new ResourceNotFoundException("Cita con id " + appointmentId + " no existe");
        }

        Appointment updatedAppointment = appointmentConverter.fromDto(appointmentDTO);
        updatedAppointment.setAppointmentId(appointmentId);
        appointmentRepository.save(updatedAppointment);
        return appointmentConverter.fromEntity(updatedAppointment);
    }

    @Override
    public String deleteAppointment(Integer appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new ResourceNotFoundException("Cita con id " + appointmentId + "no existe");
        }
        appointmentRepository.deleteById(appointmentId);

        return "Cita eliminada con exito!";

    }

}
