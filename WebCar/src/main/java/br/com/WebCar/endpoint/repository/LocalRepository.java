package br.com.WebCar.endpoint.repository;

import br.com.WebCar.endpoint.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
