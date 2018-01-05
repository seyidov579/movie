package com.seyidov.movie.service;

import com.seyidov.movie.model.Movies;
import com.seyidov.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movies create(Movies movies) {
        return this.movieRepository.save(movies);
    }
}
