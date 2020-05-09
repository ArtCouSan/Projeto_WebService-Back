package br.com.WebCar.endpoint.controller;

import br.com.WebCar.endpoint.dto.TripConfirmDTO;
import br.com.WebCar.endpoint.dto.TripDisponibilityConsultDTO;
import br.com.WebCar.endpoint.dto.VehicleResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("trip")
public class TripController {

    @GetMapping("/disponibility-consult")
    public ResponseEntity<List<VehicleResponseDTO>> tripDisponibilityConsult(@RequestBody TripDisponibilityConsultDTO disponibilityConsultDTO) {

        return null;
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> tripConfirm(@RequestBody @Valid TripConfirmDTO tripConfirmDTO) {

        return null;
    }

}
