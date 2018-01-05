package com.seyidov.movie.service;

import com.seyidov.movie.model.Country;
import com.seyidov.movie.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findOne(id);
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Country edit(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.delete(id);
    }
}
