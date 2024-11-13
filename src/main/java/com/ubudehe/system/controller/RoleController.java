package com.ubudehe.system.controller;

import com.ubudehe.system.model.Role;
import com.ubudehe.system.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRole(){
        return new ResponseEntity<>(roleService.getRole(), HttpStatus.FOUND);
    }

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @GetMapping("/role/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }
}

