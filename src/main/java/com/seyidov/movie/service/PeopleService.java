package com.seyidov.movie.service;

import com.seyidov.movie.model.People;
import java.util.List;

public interface PeopleService {
    List<People> findAll();
    People findById(Long id);
    People create(People people);
    People edit(People people);
    void deleteById(Long id);
}
