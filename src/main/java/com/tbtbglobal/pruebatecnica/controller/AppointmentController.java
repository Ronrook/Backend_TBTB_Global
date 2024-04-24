package com.tbtbglobal.pruebatecnica.controller;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentRequestDTO;
import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.services.interfaces.IAppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping()
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@Valid @RequestBody AppointmentRequestDTO request) {
        return new ResponseEntity<>(appointmentService.createAppointment(request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<AppointmentResponseDTO> getAppointments() {
        return new ResponseEntity(appointmentService.getAllAppointments(),HttpStatus.OK);
    }
}
