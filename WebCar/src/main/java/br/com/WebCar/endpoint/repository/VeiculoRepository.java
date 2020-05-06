package br.com.WebCar.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.WebCar.endpoint.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	
	Veiculo findByPlaca(String placa);

}
