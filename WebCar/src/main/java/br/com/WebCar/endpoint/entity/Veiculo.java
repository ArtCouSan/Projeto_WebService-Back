package br.com.WebCar.endpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.WebCar.endpoint.dto.VeiculoDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Table(name = "TB_VEICULO")
@EntityListeners(AuditingEntityListener.class)
public class Veiculo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String placa;
	
	@Column
	private String apelido;
	
	@Column
	private String modelo;
	
	@Column
	private Integer ano;
	
	@Column
	private String cor;
	
	@Column
	private Boolean status;
	
	@Column
	private Long quilometragem;

    public Veiculo(VeiculoDTO veiculoDTO) {
		this.placa = veiculoDTO.getPlaca();
		this.apelido = veiculoDTO.getApelido();
		this.modelo = veiculoDTO.getModelo();
		this.ano = veiculoDTO.getAno();
		this.cor = veiculoDTO.getCor();
		this.status = veiculoDTO.getStatus();
		this.quilometragem = veiculoDTO.getQuilometragem();
	}
}
