package com.andy.apireservations.controllers.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.andy.apireservations.DTO.ReservationDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

public interface ReservationResource {

    public ResponseEntity<List<ReservationDTO>> getReservations();

    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id);

    public ResponseEntity<ReservationDTO> save(@RequestBody @Valid ReservationDTO reservation);

    public ResponseEntity<ReservationDTO> update(@Min(1) @PathVariable Long id,
            @Min(1) @RequestBody ReservationDTO reservation);

    public ResponseEntity<Void> delete(@Min(1) @PathVariable Long id);
}
