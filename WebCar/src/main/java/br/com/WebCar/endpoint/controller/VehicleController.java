package br.com.WebCar.endpoint.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.WebCar.endpoint.dto.VehicleResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.WebCar.endpoint.dto.VehicleSaveDTO;
import br.com.WebCar.endpoint.service.VehicleService;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService serviceVehicle;

    public VehicleController(VehicleService serviceVehicle) {
        this.serviceVehicle = serviceVehicle;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> listVehicles() {
        return new ResponseEntity<List<VehicleResponseDTO>>(serviceVehicle.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> saveVehicle(@RequestBody @Valid VehicleSaveDTO vehicleDTO) {
        VehicleResponseDTO vehicleResponseDTO = serviceVehicle.createVehicle(vehicleDTO);

        return new ResponseEntity<VehicleResponseDTO>(vehicleResponseDTO, HttpStatus.CREATED);
    }

}
