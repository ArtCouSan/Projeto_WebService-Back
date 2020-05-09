package br.com.WebCar.endpoint.dto;

import br.com.WebCar.endpoint.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAlterDTO {

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(example = "dd-MM-yyyy")
    private LocalDate dtBirth;
    private String cpf;
    private Boolean status;
    private Boolean inVehicle;

    public UserAlterDTO() {
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
