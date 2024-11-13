package com.ubudehe.system.service;

import com.ubudehe.system.model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User addUsers(User user);

    User getUserById(Long id);
}
