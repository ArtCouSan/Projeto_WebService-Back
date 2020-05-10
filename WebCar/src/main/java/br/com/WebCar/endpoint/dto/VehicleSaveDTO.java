package br.com.WebCar.endpoint.dto;

import br.com.WebCar.endpoint.entity.Vehicle;
import br.com.WebCar.endpoint.enums.CarStep;
import lombok.Data;

@Data
public class VehicleSaveDTO {

    private String plate;
    private String nick;
    private String model;
    private Integer year;
    private String color;
    private CarStep status;
    private Long mileage;

    public VehicleSaveDTO() {
    }

    public VehicleSaveDTO(Vehicle vehicle) {
        this.plate = vehicle.getPlate();
        this.nick = vehicle.getNick();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.color = vehicle.getColor();
        this.status = vehicle.getStatus();
        this.mileage = vehicle.getMileage();
    }

    public Vehicle parseVehicleEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(this.plate);
        vehicle.setNick(this.nick);
        vehicle.setModel(this.model);
        vehicle.setYear(this.year);
        vehicle.setColor(this.color);
        vehicle.setStatus(this.status);
        vehicle.setMileage(this.mileage);
        return vehicle;
    }

}
