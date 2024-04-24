package com.tbtbglobal.pruebatecnica.services.impl;

import com.tbtbglobal.pruebatecnica.converters.AppointmentConverter;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.entities.Appointment;
import com.tbtbglobal.pruebatecnica.exceptions.ResourceNotFoundException;
import com.tbtbglobal.pruebatecnica.repository.IAppointmentRepository;
import com.tbtbglobal.pruebatecnica.services.interfaces.IAppointmentService;
import com.tbtbglobal.pruebatecnica.services.interfaces.IDoctorService;
import com.tbtbglobal.pruebatecnica.services.interfaces.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

     private final IDoctorService doctorService;

     private final IPatientService patientService;

    private final AppointmentConverter appointmentConverter;
    @Autowired
    private final ModelMapper modelMapper;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository, IDoctorService doctorService, IPatientService patientService, AppointmentConverter appointmentConverter, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.appointmentConverter = appointmentConverter;
        this.modelMapper = modelMapper;
    }


    @Override
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request) {


        // entity validations
        doctorService.getDoctorById(request.getDoctorId());
        patientService.getPatientById(request.getPatientId());

         Appointment appointment = modelMapper.map(request, Appointment.class);

         Appointment appointmentSave = appointmentRepository.save(appointment);
         return  modelMapper.map(appointmentSave, AppointmentResponseDTO.class);
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
