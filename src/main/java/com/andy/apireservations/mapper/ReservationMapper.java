package com.andy.apireservations.mapper;

import com.andy.apireservations.DTO.ReservationDTO;
import com.andy.apireservations.model.Reservation;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends Converter<Reservation, ReservationDTO> {

    @Override
    ReservationDTO convert(Reservation source);

}