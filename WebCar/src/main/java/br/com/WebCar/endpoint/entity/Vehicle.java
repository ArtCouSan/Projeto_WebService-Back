package br.com.WebCar.endpoint.entity;

import javax.persistence.*;

import br.com.WebCar.endpoint.dto.VehicleSaveDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Setter
@Getter
@Table(name = "tb_vehicle")
public class Vehicle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long id;

	@Column(name = "vehicle_plate")
	private String plate;

	@Column(name = "vehicle_nick")
	private String nick;

	@Column(name = "vehicle_model")
	private String model;

	@Column(name = "vehicle_year")
	private Integer year;

	@Column(name = "vehicle_color")
	private String color;

	@Column(name = "vehicle_status")
	private Boolean status;

	@Column(name = "vehicle_mileage")
	private Long mileage;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
	private List<Trip> trips;

}
