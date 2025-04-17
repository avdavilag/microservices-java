package com.andy.apireservations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.andy.apireservations.DTO.ReservationDTO;
import com.andy.apireservations.DTO.SegmentDTO;
import com.andy.apireservations.connector.CatalogConnector;
import com.andy.apireservations.connector.response.CityDTO;
import com.andy.apireservations.enums.APIError;
import com.andy.apireservations.exception.AndyException;
import com.andy.apireservations.model.Reservation;
import com.andy.apireservations.repository.ReservationRepository;

@Service
public class ReservationService {

    private ReservationRepository repository;

    private ConversionService conversionService;

    private CatalogConnector connector;

    @Autowired
    public ReservationService(ReservationRepository repository,
            ConversionService conversionService, CatalogConnector connector) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.connector = connector;
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
        System.out.println("Verificando el ingreso: " + reservation.getId());

        if (Objects.nonNull(reservation.getId())) {
            System.out.println("Object in object at verifity");
            throw new AndyException(APIError.RESERVATION_WITH_SAVE_ID);
        }

        System.out.println("Si paso el primer If verifando");
        checkCity(reservation);
        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public ReservationDTO update(Long id, ReservationDTO reservation) {
        if (getReservationById(id) == null) {
            throw new AndyException(APIError.RESERVATION_NOT_FOUND);
        }
        checkCity(reservation);
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

    public void checkCity(ReservationDTO reservationDTO) {
        for (SegmentDTO segmentDTO : reservationDTO.getItinerary().getSegment()) {
            CityDTO origin = connector.getCity(segmentDTO.getOrigin());
            CityDTO destination = connector.getCity(segmentDTO.getDestination());
            if (origin == null || destination == null) {
                throw new AndyException(APIError.VALIDATION_ERROR);
            } else {
                System.out.println(origin.getName());
                System.out.println(destination.getName());
            }
        }
    }
}
