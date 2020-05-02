package br.com.WebCar.endpoint.service;

import br.com.WebCar.endpoint.entity.UserVO;

import java.util.List;

public interface UserService {

    public UserVO addUser(UserVO user);
    public List<UserVO> listUser();
    public Boolean deleteUser(Long id);
    public UserVO alterUser(UserVO user);

}
