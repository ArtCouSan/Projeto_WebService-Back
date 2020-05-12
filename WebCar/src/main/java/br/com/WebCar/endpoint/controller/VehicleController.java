package br.com.WebCar.endpoint.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.WebCar.endpoint.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findVehicle(@PathVariable("id") Long id) {
        return new ResponseEntity<VehicleResponseDTO>(serviceVehicle.findVehicleById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> alterVehicle(@PathVariable Long id, @RequestBody VehicleAlterDTO vehicle) {
        return new ResponseEntity<VehicleResponseDTO>(serviceVehicle.alterVehicle(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<VehicleResponseDTO>(serviceVehicle.deleteVehicle(id), HttpStatus.OK);
    }


}
