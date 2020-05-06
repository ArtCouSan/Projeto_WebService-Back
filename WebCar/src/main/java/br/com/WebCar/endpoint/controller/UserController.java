package br.com.WebCar.endpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.WebCar.endpoint.dto.UserDTO;
import br.com.WebCar.endpoint.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired(required=true)
	private UserService userService;
	
    @GetMapping
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

}
