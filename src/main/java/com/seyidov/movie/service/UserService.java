package com.seyidov.movie.service;

import com.seyidov.movie.model.User;

public interface UserService {
    User findUserByemail(String email);
    User saveUser(User user);
}
