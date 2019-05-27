package net.spring.service;

import net.spring.entity.user.Role;

public interface RoleService {
    Role findByRole(String role);
}
