package br.com.WebCar.endpoint.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.WebCar.endpoint.dto.UserAlterDTO;
import br.com.WebCar.endpoint.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.WebCar.endpoint.dto.UserSaveDTO;
import br.com.WebCar.endpoint.entity.User;
import br.com.WebCar.endpoint.repository.UserRepository;
import br.com.WebCar.endpoint.service.UserService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserSaveDTO userDTO) {
        User user = userRepository.save(userDTO.parseUserEntity());
        return new UserResponseDTO(user);
    }

    public List<UserResponseDTO> listUsers() {
        return userRepository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public UserResponseDTO deleteUser(Long id) {
        User userDelete = userExist(id);
        userDelete.setStatus(false);

        userRepository.save(userDelete);

        return new UserResponseDTO(userDelete);
    }

    public UserResponseDTO alterUser(Long id, UserAlterDTO user) {
        User userUpdate = userExist(id);
        userUpdate.setName(user.getName());
        userUpdate.setDtBirth(user.getDtBirth());
        userUpdate.setStatus(user.getStatus());
        userUpdate.setInVehicle(user.getInVehicle());

        userRepository.save(userUpdate);

        return new UserResponseDTO(userUpdate);
    }

    private User userExist(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with id: ".concat(id.toString()));
        }
    }

}
