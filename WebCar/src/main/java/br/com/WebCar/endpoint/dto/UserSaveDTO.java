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
	private String password;

    public UserSaveDTO(){}

    public UserSaveDTO(User user) {
        this.name = user.getName();
        this.dtBirth = user.getDtBirth();
        this.cpf = user.getCpf();
        this.password = user.getPassword();
    }

    public User parseUserEntity(){
        User user = new User();
        user.setName(this.name);
        user.setDtBirth(this.dtBirth);
        user.setCpf(this.cpf);
        user.setPassword(this.password);
        return user;
    }
	
}
