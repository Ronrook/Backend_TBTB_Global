package com.tbtbglobal.pruebatecnica.dtos;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO {
    private Integer appointmentId;

    private LocalDate appointmentDate;

    private Time appointmentTime;

    private  String patientId;

    private  String doctorId;

    private boolean isAttended;
}
