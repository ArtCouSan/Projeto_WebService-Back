package br.com.WebCar.endpoint.controller;

import br.com.WebCar.endpoint.dto.TripConfirmDTO;
import br.com.WebCar.endpoint.dto.TripDisponibilityConsultDTO;
import br.com.WebCar.endpoint.dto.TripResponseDTO;
import br.com.WebCar.endpoint.dto.VehicleResponseDTO;
import br.com.WebCar.endpoint.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/disponibility")
    public ResponseEntity<List<VehicleResponseDTO>> tripDisponibilityConsult(@RequestBody TripDisponibilityConsultDTO disponibilityConsultDTO) {
        return new ResponseEntity<List<VehicleResponseDTO>>(tripService.disponibilityConsult(disponibilityConsultDTO), HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<TripResponseDTO> tripConfirm(@RequestBody @Valid TripConfirmDTO tripConfirmDTO) {
        return new ResponseEntity<TripResponseDTO>(tripService.tripConfirm(tripConfirmDTO), HttpStatus.OK);
    }

}
