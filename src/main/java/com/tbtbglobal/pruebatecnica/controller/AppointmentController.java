package com.tbtbglobal.pruebatecnica.controller;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.services.interfaces.IAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    public List<AppointmentResponseDTO> getAppointments() {
        return appointmentService.getAllAppointments();
    }
}
