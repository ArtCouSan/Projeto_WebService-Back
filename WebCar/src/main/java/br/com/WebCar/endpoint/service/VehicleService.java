package br.com.WebCar.endpoint.service;

import java.util.List;

import br.com.WebCar.endpoint.dto.VehicleAlterDTO;
import br.com.WebCar.endpoint.dto.VehicleResponseDTO;
import br.com.WebCar.endpoint.dto.VehicleSaveDTO;

public interface VehicleService {
	
	public List<VehicleResponseDTO> getAllVehicles();
	public VehicleResponseDTO findVehicleByPlate(String plate);
	public VehicleResponseDTO createVehicle(VehicleSaveDTO vehicleDTO);
	public VehicleResponseDTO alterVehicle(Long id, VehicleAlterDTO vehicleDTO);
	public VehicleResponseDTO deleteVehicle(Long id);

}
