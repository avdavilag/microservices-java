package com.andy.apireservations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.andy.apireservations.DTO.ReservationDTO;
import com.andy.apireservations.enums.APIError;
import com.andy.apireservations.exception.AndyException;
import com.andy.apireservations.model.Reservation;
import com.andy.apireservations.repository.ReservationRepository;

@Service
public class ReservationService {

    private ReservationRepository repository;

    private ConversionService conversionService;

    @Autowired
    public ReservationService(ReservationRepository repository,
            ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public List<ReservationDTO> getReservations() {
        return conversionService.convert(repository.getReservations(), List.class);
    }

    public ReservationDTO getReservationById(Long id) {
        Optional<Reservation> result = repository.getReservationById(id);
        if (result.isEmpty()) {
            throw new AndyException(APIError.RESERVATION_NOT_FOUND);
        }
        return conversionService.convert(result.get(), ReservationDTO.class);
    }

    public ReservationDTO save(ReservationDTO reservation) {
        if (Objects.nonNull(reservation.getId())) {

            throw new AndyException(APIError.RESERVATION_WITH_SAVE_ID);
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public ReservationDTO update(Long id, ReservationDTO reservation) {
        if (getReservationById(id) == null) {
            throw new AndyException(APIError.RESERVATION_NOT_FOUND);
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.update(id, Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public void delete(Long id) {
        if (getReservationById(id) == null) {
            throw new AndyException(APIError.RESERVATION_NOT_FOUND);
        }

        repository.delete(id);
    }
}
