package br.com.WebCar.endpoint.dto;

import java.time.LocalDate;

import br.com.WebCar.endpoint.entity.User;
import lombok.Data;

@Data
public class UserDTO {
	private String name;
	private LocalDate dtBirth;
	private String cpf;
	private Boolean status;
	private Boolean inVehicle;
	
    public UserDTO(){}

    public UserDTO(User user) {
        this.name = user.getName();
        this.dtBirth = user.getDtBirth();
        this.cpf = user.getCpf();
        this.status = user.getStatus();
        this.inVehicle = user.getInVehicle();
    }

	
}
