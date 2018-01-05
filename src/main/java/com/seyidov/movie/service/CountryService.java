package com.seyidov.movie.service;

import com.seyidov.movie.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country create(Country country);
    Country edit(Country country);
    void deleteById(Long id);
}
