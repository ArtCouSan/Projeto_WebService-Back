package br.com.WebCar.endpoint.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.WebCar.endpoint.dto.UserDTO;

@Entity
@Table(name = "tb_user")
public class User {

    @GeneratedValue
    @Id
    @Column(name ="user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_birth")
    private LocalDate dtBirth;

    @Column(name = "user_cpf")
    private String cpf;

    @Column(name = "user_status")
    private Boolean status;

    @Column(name = "user_in_vehicle")
    private Boolean inVehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(LocalDate dtBirth) {
        this.dtBirth = dtBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getInVehicle() {
        return inVehicle;
    }

    public void setInVehicle(Boolean inVehicle) {
        this.inVehicle = inVehicle;
    }
    
	public User() {
    }

	public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.dtBirth = userDTO.getDtBirth();
        this.cpf = userDTO.getCpf();
        this.status = userDTO.getStatus();
        this.inVehicle = userDTO.getInVehicle();
	}
	
	
}
