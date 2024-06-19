package com.app.services;

import com.app.entities.User;

public interface UserService {
	User registerUser(User user);
    User loginUser(String username, String password);
    User getUserById(Long id);
    User updateUser(User user);

}
