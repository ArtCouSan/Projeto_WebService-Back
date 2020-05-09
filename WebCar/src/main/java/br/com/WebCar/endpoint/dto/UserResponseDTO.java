package br.com.WebCar.endpoint.dto;

import br.com.WebCar.endpoint.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {

    private String name;
    private LocalDate dtBirth;
    private String cpf;
    private Boolean status;
    private Boolean inVehicle;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.dtBirth = user.getDtBirth();
        this.cpf = user.getCpf();
        this.status = user.getStatus();
        this.inVehicle = user.getInVehicle();
    }

    public User parseUserEntity(){
        User user = new User();
        user.setName(this.name);
        user.setDtBirth(this.dtBirth);
        user.setCpf(this.cpf);
        user.setStatus(this.status);
        user.setInVehicle(this.inVehicle);
        return user;
    }

}
