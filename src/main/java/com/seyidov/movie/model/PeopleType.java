package com.seyidov.movie.model;

import javax.persistence.*;

@Entity
@Table(name = "people_type")
public class PeopleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public PeopleType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PeopleType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
