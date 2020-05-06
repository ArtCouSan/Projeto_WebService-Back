package br.com.WebCar.endpoint.dto;

import br.com.WebCar.endpoint.entity.Veiculo;
import lombok.Data;

@Data
public class VeiculoDTO {
	private String placa;
	private String apelido;
	private String modelo;
	private Integer ano;
	private String cor;
	private Boolean status;
	private Long quilometragem;

	public VeiculoDTO() {
	}

	public VeiculoDTO(Veiculo veiculo) {
		this.placa = veiculo.getPlaca();
		this.apelido = veiculo.getApelido();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.cor = veiculo.getCor();
		this.status = veiculo.getStatus();
		this.quilometragem = veiculo.getQuilometragem();
	}

}
