package com.ubudehe.system.service;

import com.ubudehe.system.exception.ResourceNotFoundException;
import com.ubudehe.system.model.User;
import com.ubudehe.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUsers(User user){
        return userRepository.save(user);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
    }

}