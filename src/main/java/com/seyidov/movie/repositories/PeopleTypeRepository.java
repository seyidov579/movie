package com.seyidov.movie.repositories;

import com.seyidov.movie.model.PeopleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleTypeRepository extends JpaRepository<PeopleType,Long>{
}
