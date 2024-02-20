package br.com.zapcarbackend.zapcar_backend.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zapcarbackend.zapcar_backend.domain.User;
import br.com.zapcarbackend.zapcar_backend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDB = repository.findById(userId).get();

        userDB.setNome(user.getNome());
        userDB.setCidade(user.getCidade());
        userDB.setUf(user.getUf());
        userDB.setFoto(user.getFoto());

        if (Objects.nonNull(user.getPlaca()) && !"".equalsIgnoreCase(user.getPlaca())) {
            userDB.setPlaca(user.getPlaca());
        }
        if (Objects.nonNull(user.getTelefone()) && !"".equalsIgnoreCase(user.getTelefone())) {
            userDB.setTelefone(user.getTelefone());
        }
        if (Objects.nonNull(user.getModeloCarro()) && !"".equalsIgnoreCase(user.getModeloCarro())) {
            userDB.setModeloCarro(user.getModeloCarro());
        }
        if (Objects.nonNull(user.getCorCarro()) && !"".equalsIgnoreCase(user.getCorCarro())) {
            userDB.setCorCarro(user.getCorCarro());
        }

        return repository.save(userDB);

    }

    @Override
    public void deleteUserById(Long userId) {
        repository.deleteById(userId);
    }

}
