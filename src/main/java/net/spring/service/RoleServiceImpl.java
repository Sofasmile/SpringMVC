package net.spring.service;

import lombok.RequiredArgsConstructor;
import net.spring.entity.user.Role;
import net.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role).orElse(new Role());
    }
}
