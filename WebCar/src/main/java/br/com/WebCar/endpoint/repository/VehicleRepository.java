package br.com.WebCar.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.WebCar.endpoint.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public Optional<Vehicle> findByPlate(String plate);

}
