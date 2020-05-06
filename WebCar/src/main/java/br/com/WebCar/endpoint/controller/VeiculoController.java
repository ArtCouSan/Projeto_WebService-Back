package br.com.WebCar.endpoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.WebCar.endpoint.dto.VeiculoDTO;
import br.com.WebCar.endpoint.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
	
	@Autowired(required=true)
	private VeiculoService veiculoService; 
	
	@GetMapping
    public List<VeiculoDTO> listVeiculos(){
        return veiculoService.getAllVeiculos();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO salvarCliente(@RequestBody @Valid VeiculoDTO veiculoDTO){
        return veiculoService.createVeiculo(veiculoDTO);
    }
	

}
