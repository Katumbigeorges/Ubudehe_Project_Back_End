package com.ubudehe.system.service;

import com.ubudehe.system.exception.ResourceNotFoundException;
import com.ubudehe.system.model.Role;
import com.ubudehe.system.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{
    private final RoleRepository roleRepository;


    @Override
    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role){
        return roleRepository.save(role);
    }


    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found for this id : " + id));
    }

}
