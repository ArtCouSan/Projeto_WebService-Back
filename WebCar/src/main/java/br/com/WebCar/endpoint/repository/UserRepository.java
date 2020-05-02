package br.com.WebCar.endpoint.repository;

import br.com.WebCar.endpoint.entity.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {
}
