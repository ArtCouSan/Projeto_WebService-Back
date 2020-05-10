package br.com.WebCar.endpoint.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.WebCar.endpoint.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public Optional<Vehicle> findByPlate(String plate);

	@Query("select  v from Vehicle v where v.status = 'DISPONIBLE'")
	public List<Vehicle> findVehicleRandom(Pageable pageable);

}
