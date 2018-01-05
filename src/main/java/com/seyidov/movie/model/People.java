package com.seyidov.movie.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.Set;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String first_name;

    @Column(nullable = false, length = 30)
    private String last_name;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="photo", nullable=false)
    private String photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_peopletype", joinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "peopletype_id", referencedColumnName = "id"))
    private Set<PeopleType> peopleType;

    public People() {
    }

    public People(String first_name, String last_name, String photo, Set<PeopleType> peopleType) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.photo = photo;
        this.peopleType = peopleType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<PeopleType> getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(Set<PeopleType> peopleType) {
        this.peopleType = peopleType;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", photo=" + photo +
                ", peopleType=" + peopleType +
                '}';
    }
}
