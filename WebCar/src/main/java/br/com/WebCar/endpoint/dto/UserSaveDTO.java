package br.com.WebCar.endpoint.dto;

import java.time.LocalDate;

import br.com.WebCar.endpoint.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserSaveDTO {

	private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(example = "dd-MM-yyyy")
    private LocalDate dtBirth;
	private String cpf;
	private Boolean status;
	private Boolean inVehicle;
	
    public UserSaveDTO(){}

    public UserSaveDTO(User user) {
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
