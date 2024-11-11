package com.andy.apireservations.controllers;

import com.andy.apireservations.DTO.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Anderson Vinicio Davila Guerrero
@RestController
@RequestMapping("/{reservations}")
public class ReservationController {

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        List<ReservationDTO> response = new ArrayList<>();
        response.add(new ReservationDTO());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationsById(@PathVariable Long id) {
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ReservationDTO> save(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}


