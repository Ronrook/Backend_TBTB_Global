package com.tbtbglobal.pruebatecnica.converters;

import com.tbtbglobal.pruebatecnica.dtos.AppointmentResponseDTO;
import com.tbtbglobal.pruebatecnica.entities.Appointment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppointmentConverter {

    @Autowired
    private final ModelMapper modelMapper;

    public AppointmentConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AppointmentResponseDTO fromEntity(Appointment appointment) {
        return  modelMapper.map(appointment, AppointmentResponseDTO.class);
    }
}
