package com.andy.apireservations.DTO;

import java.util.List;

public class ReservationDTO {
    private Long id;
    private List<PassangerDTO>passagers;
    private ItenaryDTO itenary;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PassangerDTO> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<PassangerDTO> passagers) {
        this.passagers = passagers;
    }

    public ItenaryDTO getItenary() {
        return itenary;
    }

    public void setItenary(ItenaryDTO itenary) {
        this.itenary = itenary;
    }
}
