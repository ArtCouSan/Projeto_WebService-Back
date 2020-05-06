package br.com.WebCar.endpoint.service;

import java.util.List;

import br.com.WebCar.endpoint.dto.VeiculoDTO;

public interface VeiculoService {
	
	List<VeiculoDTO> getAllVeiculos();
	VeiculoDTO findVeiculosByPlaca(String placa);
	VeiculoDTO createVeiculo(VeiculoDTO veiculoDTO);
	VeiculoDTO updateVeiculo(Integer id, VeiculoDTO veiculoDTO);
    void deleteVeiculo(Integer id);

}
