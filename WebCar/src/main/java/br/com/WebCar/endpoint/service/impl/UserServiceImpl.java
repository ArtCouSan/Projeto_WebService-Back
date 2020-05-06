package br.com.WebCar.endpoint.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.WebCar.endpoint.dto.UserDTO;
import br.com.WebCar.endpoint.entity.User;
import br.com.WebCar.endpoint.repository.UserRepository;
import br.com.WebCar.endpoint.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO addUser(UserDTO userDTO) {
    	User user = userRepository.save(new User(userDTO));
        return new UserDTO(user);
    }

    public List<UserDTO> listUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	public UserDTO alterUser(Long id, UserDTO user) {
		User userAtualizar = userRepository.findById(id).get();
		userAtualizar.setName(user.getName());
		userAtualizar.setDtBirth(user.getDtBirth());
		userAtualizar.setStatus(user.getStatus());
		userAtualizar.setInVehicle(user.getInVehicle());
		
		userRepository.save(userAtualizar);
		
        return new UserDTO(userAtualizar);
	}
}
