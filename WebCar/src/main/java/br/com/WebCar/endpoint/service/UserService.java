package br.com.WebCar.endpoint.service;

import java.util.List;

import br.com.WebCar.endpoint.dto.UserAlterDTO;
import br.com.WebCar.endpoint.dto.UserResponseDTO;
import br.com.WebCar.endpoint.dto.UserSaveDTO;
import br.com.WebCar.endpoint.entity.User;

public interface UserService {

    public UserResponseDTO createUser(UserSaveDTO user);
    public List<UserResponseDTO> listUsers();
    public UserResponseDTO findUser(Long id);
    public UserResponseDTO deleteUser(Long id);
    public UserResponseDTO alterUser(Long id, UserAlterDTO user);
    public User userExist(Long id);

}
