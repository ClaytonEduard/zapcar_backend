package br.com.zapcarbackend.zapcar_backend.service;

import java.util.List;

import br.com.zapcarbackend.zapcar_backend.domain.User;

public interface UserService {
    User saveUser(User user);

    List<User> fetchUsers();

    User updateUser(User user, Long userId);

    void deleteUserById(Long userId);

}
