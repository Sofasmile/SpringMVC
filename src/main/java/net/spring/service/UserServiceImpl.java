package net.spring.service;

import lombok.RequiredArgsConstructor;
import net.spring.entity.user.Role;
import net.spring.entity.user.User;
import net.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String ROLE = "USER";

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        Role userRole = roleService.findByRole(ROLE);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
                .setActive(1)
                .setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
