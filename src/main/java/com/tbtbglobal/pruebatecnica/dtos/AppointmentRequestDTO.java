package com.tbtbglobal.pruebatecnica.dtos;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDTO {

    private Integer appointmentId;

    @NotNull(message = "La fecha de la cita no puede ser nula.")
    @FutureOrPresent(message = "La fecha de la cita no debe estar en el pasado.")
    private LocalDate appointmentDate;

    @NotNull(message = "La hora de la cita no puede ser nula.")
    private Time appointmentTime;

    @NotNull(message = "El id del paciente no puede ser nulo.")
    private  String patientId;

    @NotNull(message = "El id del doctor no puede ser nulo.")
    private  String doctorId;

    private boolean isAttended;
}

