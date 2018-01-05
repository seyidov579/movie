package com.seyidov.movie.service;

import com.seyidov.movie.model.PeopleType;

import java.util.List;

public interface PeopleTypeService {
    List<PeopleType> findAll();
    PeopleType findById(Long id);
    PeopleType create(PeopleType peopleType);
    PeopleType edit(PeopleType peopleType);
    void deleteById(Long id);
}
