package br.com.WebCar.endpoint.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.WebCar.endpoint.dto.VehicleAlterDTO;
import br.com.WebCar.endpoint.dto.VehicleResponseDTO;
import br.com.WebCar.endpoint.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.WebCar.endpoint.dto.VehicleSaveDTO;
import br.com.WebCar.endpoint.entity.Vehicle;
import br.com.WebCar.endpoint.repository.VehicleRepository;
import br.com.WebCar.endpoint.service.VehicleService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(VehicleResponseDTO::new).collect(Collectors.toList());
    }

    public VehicleResponseDTO findVehicleByPlate(String plate) {
        Vehicle vehicle = vehicleExist(null, plate);

        return new VehicleResponseDTO(vehicle);
    }

    public VehicleResponseDTO createVehicle(VehicleSaveDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.save(vehicleDTO.parseVehicleEntity());

        return new VehicleResponseDTO(vehicle);
    }

    public VehicleResponseDTO alterVehicle(Long id, VehicleAlterDTO vehicleDTO) {
        Vehicle vehicle = vehicleExist(id, null);
        vehicle.setNick(vehicleDTO.getNick());
        vehicle.setMileage(vehicleDTO.getMileage());

        vehicleRepository.save(vehicle);

        return new VehicleResponseDTO(vehicle);
    }

    public VehicleResponseDTO deleteVehicle(Long id) {
        Vehicle vehicle = vehicleExist(id, null);
        vehicle.setStatus(false);

        vehicleRepository.save(vehicle);

        return new VehicleResponseDTO(vehicle);
    }

    private Vehicle vehicleExist(Long id, String plate) {

        Optional<Vehicle> vehicle = null;

        if (Optional.of(id).isPresent()) {
            vehicle = vehicleRepository.findById(id);
        } else {
            vehicle = vehicleRepository.findByPlate(plate);
        }

        if (vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Vehicle not found with id: ".concat(id.toString()));
        }
    }

}
