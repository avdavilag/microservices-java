package com.andy.apireservations.repository;

import com.andy.apireservations.model.Reservation;
import com.andy.apireservations.model.Passenger;
import com.andy.apireservations.model.Price;
import com.andy.apireservations.model.Segment;
import com.andy.apireservations.model.Itinerary;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
public class ReservationRepository {
    static List<Reservation> reservations = new ArrayList<>();
    static {

        Passenger passenger = new Passenger();
        passenger.setFirstName("Andres");
        passenger.setLastName("Sacco");
        passenger.setId(1L);
        passenger.setDocumentType("DNI");
        passenger.setDocumentNumber("12345678");
        passenger.setBirthday(LocalDate.of(1985, 1, 1));

        Price price = new Price();
        price.setBasePrice(BigDecimal.ONE);
        price.setTotalPax(BigDecimal.ZERO);
        price.setTotalPrice(BigDecimal.ONE);

        Segment segment = new Segment();
        segment.setArrival("2025-01-01");
        segment.setDeparture("2024-12-31");
        segment.setOrigin("EZE");
        segment.setDestination("MIA");
        segment.setCarrier("AA");
        segment.setId(1L);

        Itinerary itinerary = new Itinerary();
        itinerary.setId(1L);
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        reservations.add(reservation);
    }


    public List<Reservation> getReservations() {   return reservations; }
    
    public Optional<Reservation> getReservationById(Long id) {
        List<Reservation> result= reservations.stream().
        filter(reservation -> Objects.equals(reservation.getId(), id)).toList();

        Reservation reservation= !result.isEmpty() ? result.get(0) : null;
        return Optional.ofNullable(reservation);
    }

    public Reservation save(Reservation reservation) {
        reservation.setId((long) (reservations.size() + 1));
        reservations.add(reservation);
        return reservation;
    }

    public void delete(Long id) {
        List<Reservation> result= reservations.stream()
        .filter(reservation -> !Objects.equals(reservation.getId(), id)).toList();
        reservations.remove(result.get(0));
    }   

}
