package br.com.zapcarbackend.zapcar_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zapcarbackend.zapcar_backend.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}