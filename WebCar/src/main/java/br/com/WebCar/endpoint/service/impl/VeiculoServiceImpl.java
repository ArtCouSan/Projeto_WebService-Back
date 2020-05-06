package br.com.WebCar.endpoint.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.WebCar.endpoint.dto.VeiculoDTO;
import br.com.WebCar.endpoint.entity.Veiculo;
import br.com.WebCar.endpoint.repository.VeiculoRepository;
import br.com.WebCar.endpoint.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	private VeiculoRepository veiculoRepository;
	
	public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

	public List<VeiculoDTO> getAllVeiculos() {
		return veiculoRepository.findAll().stream().map(VeiculoDTO::new).collect(Collectors.toList());
	}

	public VeiculoDTO findVeiculosByPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);
		return new VeiculoDTO(veiculo);
	}

	public VeiculoDTO createVeiculo(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = veiculoRepository.save(new Veiculo(veiculoDTO));
		return new VeiculoDTO(veiculo);
	}

	public VeiculoDTO updateVeiculo(Integer id, VeiculoDTO veiculoDTO) {
		Veiculo veiculo = veiculoRepository.findById(id).get();
		
		veiculo.setApelido(veiculoDTO.getApelido());
		veiculo.setQuilometragem(veiculoDTO.getQuilometragem());
		
		return new VeiculoDTO(veiculo);
	}

	public void deleteVeiculo(Integer id) {
		veiculoRepository.deleteById(id);

	}

}
