package br.com.WebCar.endpoint.service;

import java.util.List;

import br.com.WebCar.endpoint.dto.UserDTO;

public interface UserService {

    public UserDTO addUser(UserDTO user);
    public List<UserDTO> listUsers();
    public void deleteUser(Long id);
    public UserDTO alterUser(Long id, UserDTO user);

}
