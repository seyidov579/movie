package com.seyidov.movie.repositories;

import com.seyidov.movie.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies,Long> {
}
