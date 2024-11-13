package com.ubudehe.system.service;

import com.ubudehe.system.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getRole();

    Role addRole(Role role);

    Role getRoleById(Long id);
}
