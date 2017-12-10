package com.homework.services;

import com.homework.dao.UserRepository;
import com.homework.exceptions.UserNotFoundException;
import com.homework.models.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.homework.models.Role.USER;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser findByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public boolean exist(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public AppUser create(final AppUser entity) {
        entity.setRole(USER);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public AppUser findById(UUID id) {
        return null;
    }

}
