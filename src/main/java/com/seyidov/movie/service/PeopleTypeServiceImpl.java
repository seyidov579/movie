package com.seyidov.movie.service;

import com.seyidov.movie.model.PeopleType;
import com.seyidov.movie.repositories.PeopleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PeopleTypeServiceImpl implements PeopleTypeService {

    @Autowired
    private PeopleTypeRepository peopleTypeRepository;

    @Override
    public List<PeopleType> findAll() {
        return this.peopleTypeRepository.findAll();
    }

    @Override
    public PeopleType findById(Long id) {
        return this.peopleTypeRepository.findOne(id);
    }

    @Override
    public PeopleType create(PeopleType peopleType) {
        return this.peopleTypeRepository.save(peopleType);
    }

    @Override
    public PeopleType edit(PeopleType peopleType) {
        return this.peopleTypeRepository.save(peopleType);
    }

    @Override
    public void deleteById(Long id) {
        this.peopleTypeRepository.delete(id);
    }
}
