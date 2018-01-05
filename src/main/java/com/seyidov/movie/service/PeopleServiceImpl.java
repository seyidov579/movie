package com.seyidov.movie.service;

import com.seyidov.movie.model.People;
import com.seyidov.movie.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> findAll() {
        return this.peopleRepository.findAll();
    }

    @Override
    public People findById(Long id) {
        return this.peopleRepository.findOne(id);
    }

    @Override
    public People create(People people) {
        return this.peopleRepository.save(people);
    }

    @Override
    public People edit(People people) {
        return this.peopleRepository.save(people);
    }

    @Override
    public void deleteById(Long id) {
        this.peopleRepository.delete(id);
    }

}
