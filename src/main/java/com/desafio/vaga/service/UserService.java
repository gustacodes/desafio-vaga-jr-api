package com.desafio.vaga.service;

import com.desafio.vaga.entities.User;
import com.desafio.vaga.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User validation(Long id) {
        Optional<User> userValidation = userRepository.findById(id);
        userValidation.get().setStatus(true);
        return userRepository.save(userValidation.get());
    }
}
