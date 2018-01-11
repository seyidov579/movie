package com.seyidov.movie.service;

import com.seyidov.movie.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface RoleService {
    Role findByRole(String role);
}
