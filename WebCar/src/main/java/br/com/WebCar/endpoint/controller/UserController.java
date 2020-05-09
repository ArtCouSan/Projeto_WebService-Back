package br.com.WebCar.endpoint.controller;

import java.util.List;

import br.com.WebCar.endpoint.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.WebCar.endpoint.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	private final UserService serviceUser;

    public UserController(UserService serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listUsers(){
        return new ResponseEntity<List<UserResponseDTO>>(serviceUser.listUsers(), HttpStatus.OK);
    }

}
