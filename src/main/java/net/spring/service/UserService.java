package net.spring.service;

import net.spring.entity.user.User;

public interface UserService {
    User findByName(String userName);

    void save(User user);
}
