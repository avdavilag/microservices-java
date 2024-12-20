package com.andy.apireservations.mapper;

import com.andy.apireservations.DTO.ReservationDTO;
import com.andy.apireservations.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationDTOMapper extends Converter<ReservationDTO, Reservation> {

    @Override
    Reservation convert(ReservationDTO source);

}