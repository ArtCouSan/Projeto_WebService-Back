package br.com.WebCar.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.WebCar.endpoint.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
