package com.tbtbglobal.pruebatecnica.services.interfaces;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;

import java.util.List;

public interface IAppointmentService {

    AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO);

    List<AppointmentResponseDTO> getAllAppointments();

    AppointmentResponseDTO getAppointmentById(Integer appointmentId);

    AppointmentResponseDTO updateAppointment(Integer appointmentId, AppointmentRequestDTO updatedAppointment);

    void deleteAppointment(Integer appointmentId);

    List<AppointmentResponseDTO> getAppointmentsByDoctorId(Integer employeeId);

    List<AppointmentResponseDTO> getAppointmentsByPatientId(Integer customerId);

}
