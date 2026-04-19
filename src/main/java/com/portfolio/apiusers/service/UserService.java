package com.portfolio.apiusers.service;

import com.portfolio.apiusers.exception.ResourceNotFoundException;
import com.portfolio.apiusers.model.User;
import com.portfolio.apiusers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado com id: " + id));
    }

    public User create(User user) {
        // Em projeto real, a senha deve ser criptografada antes de salvar.
        return userRepository.save(user);
    }

    public User update(Long id, User updatedUser) {
        User existingUser = findById(id);

        existingUser.setNome(updatedUser.getNome());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setSenha(updatedUser.getSenha());

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        User existingUser = findById(id);
        userRepository.delete(existingUser);
    }
}
