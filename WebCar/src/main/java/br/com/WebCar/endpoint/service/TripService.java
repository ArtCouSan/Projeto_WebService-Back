package br.com.WebCar.endpoint.service;

import br.com.WebCar.endpoint.dto.TripConfirmDTO;
import br.com.WebCar.endpoint.dto.TripDisponibilityConsultDTO;
import br.com.WebCar.endpoint.dto.TripResponseDTO;
import br.com.WebCar.endpoint.dto.VehicleResponseDTO;

import java.util.List;

public interface TripService {

    public List<VehicleResponseDTO> disponibilityConsult(TripDisponibilityConsultDTO disponibilityConsultDTO);
    public TripResponseDTO tripConfirm(TripConfirmDTO tripConfirmDTO);

}
