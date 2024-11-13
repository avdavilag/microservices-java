package com.andy.apireservations.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.andy.apireservations.DTO.ReservationDTO;
import com.andy.apireservations.exception.AndyException;
import com.andy.apireservations.model.Reservation;
import com.andy.apireservations.repository.ReservationRepository;

@Service
public class ReservationService {
    
private ReservationRepository repository;

public List<ReservationDTO> getReservations() {
    
}

public List<ReservationDTO> getReservationsById(Long id) {
    Optional<Reservation> result=repository.getReservationById(id);
    if(result.isEmpty()){
        throw new AndyException("Reservation not found");
    }
}

public List<ReservationDTO> save(ReservationDTO reservation) {
    
    if(Objects.nonNull(reservation.getId())){
        throw new AndyException("Duplicated It");
    }
}
public List<ReservationDTO> update(Long id, ReservationDTO reservation) {
    if(getReservationsById(id)==null){
        throw new AndyException("Not exist");
    }
}
public void delete(Long id) {
    if(getReservationsById(id)==null){
        throw new AndyException("Not exist");
    }
        repository.delete(id);
}
}
