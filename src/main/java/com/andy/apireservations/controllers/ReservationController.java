package com.andy.apireservations.controllers;

import com.andy.apireservations.DTO.ReservationDTO;

import com.andy.apireservations.DTO.PassengerDTO;
import com.andy.apireservations.exception.AndyException;
import com.andy.apireservations.service.ReservationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Anderson Vinicio Davila Guerrero
@Validated
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        List<ReservationDTO> response = service.getReservations();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        ReservationDTO response = service.getReservationById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> save(@Valid @RequestBody ReservationDTO reservation) {
        //validateSave(reservation);
        ReservationDTO response = service.save(reservation);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update(@Min(1) @PathVariable Long id,
            @Min(1) @RequestBody ReservationDTO reservation) {
        //validateUpdate(reservation);
        ReservationDTO response = service.update(id, reservation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Min(1) @PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // private void validateSave(ReservationDTO reservation) {
    //     if (Objects.nonNull(reservation.getId()) ||
    //             Objects.isNull(reservation.getItinerary()) ||
    //             Objects.isNull(reservation.getPassengers())) {
    //         throw new AndyException("Somethings is not okey, please check the root nodes flag verifity - insert");
    //     }
    //     ValidatePassager(reservation.getPassengers());
    // }

    // private void validateUpdate(ReservationDTO reservation) {
    //     if (Objects.isNull(reservation.getId()) ||
    //             Objects.isNull(reservation.getItinerary()) ||
    //             Objects.isNull(reservation.getPassengers())) {
    //         throw new AndyException("Somethings is not okey, please check the root nodes flag verifity - update");
    //     }
    //     ValidatePassager(reservation.getPassengers());
    // }

    // private void ValidatePassager(List<PassengerDTO> passagers) {
    //     for (PassengerDTO passager : passagers) {
    //         if (Objects.isNull(passager.getFirstName())
    //                 || passager.getFirstName().isEmpty() ||
    //                 passager.getFirstName().length() > 30) {
    //             throw new AndyException("The First name is very wrong");
    //         }
    //     }
    // }

}
