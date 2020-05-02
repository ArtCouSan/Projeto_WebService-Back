package br.com.WebCar.endpoint.service.impl;

import br.com.WebCar.endpoint.entity.UserVO;
import br.com.WebCar.endpoint.repository.UserRepository;
import br.com.WebCar.endpoint.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserVO addUser(UserVO user) {
        return null;
    }

    @Override
    public List<UserVO> listUser() {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }

    @Override
    public UserVO alterUser(UserVO user) {
        return null;
    }
}
