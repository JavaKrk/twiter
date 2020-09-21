package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.RoleEntity;
import com.javakrk.twiter.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleEntity getRoleEntityByRole(String role) {
        return roleRepository.getRoleEntityByRole(role);
    }
}
