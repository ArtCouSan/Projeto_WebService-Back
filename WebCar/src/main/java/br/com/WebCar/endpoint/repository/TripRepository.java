package br.com.WebCar.endpoint.repository;

import br.com.WebCar.endpoint.entity.Local;
import br.com.WebCar.endpoint.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {
}
