package net.spring.service;

import net.spring.entity.user.User;

public interface UserService {
    User findByUserName(String userName);

    void saveUser(User user);
}
