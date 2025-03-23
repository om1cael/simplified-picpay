package com.om1cael.simplified.picpay.service;

import com.om1cael.simplified.picpay.model.User;
import com.om1cael.simplified.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
