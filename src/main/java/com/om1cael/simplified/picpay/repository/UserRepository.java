package com.om1cael.simplified.picpay.repository;

import com.om1cael.simplified.picpay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCPF(String cpf);
}
