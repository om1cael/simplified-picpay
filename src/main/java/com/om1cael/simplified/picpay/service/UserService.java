package com.om1cael.simplified.picpay.service;

import com.om1cael.simplified.picpay.model.User;
import com.om1cael.simplified.picpay.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        user.setBalance(500.0);
        return userRepository.save(user);
    }

    public User getByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
