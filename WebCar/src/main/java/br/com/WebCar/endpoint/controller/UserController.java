package br.com.WebCar.endpoint.controller;

import java.util.List;

import br.com.WebCar.endpoint.dto.UserAlterDTO;
import br.com.WebCar.endpoint.dto.UserResponseDTO;
import br.com.WebCar.endpoint.dto.UserSaveDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.WebCar.endpoint.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService serviceUser;

    public UserController(UserService serviceUser) {
        this.serviceUser = serviceUser;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserSaveDTO user) {
        return new ResponseEntity<UserResponseDTO>(serviceUser.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable("id") Long id) {
        return new ResponseEntity<UserResponseDTO>(serviceUser.findUser(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> alterUser(@PathVariable Long id, @RequestBody UserAlterDTO user) {
        return new ResponseEntity<UserResponseDTO>(serviceUser.alterUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<UserResponseDTO>(serviceUser.deleteUser(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        return new ResponseEntity<List<UserResponseDTO>>(serviceUser.listUsers(), HttpStatus.OK);
    }

}
