package com.seyidov.movie.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "cover", nullable=false)
    private String cover;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 30)
    private Integer imdb;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date creatdate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Country.class)
    private Country country;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date minute;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_category", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_directed", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"))
    private Set<People> directed;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_writer", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"))
    private Set<People> writer;

    public Movies(){
    }

    public Movies(String name, String cover, String description, Integer imdb, Date creatdate, Country country, Date minute, Set<Category> category, Set<People>  directed, Set<People> writer) {
        this.name = name;
        this.cover = cover;
        this.description = description;
        this.imdb = imdb;
        this.creatdate = creatdate;
        this.country = country;
        this.minute = minute;
        this.category = category;
        this.directed = directed;
        this.writer = writer;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImdb() {
        return imdb;
    }

    public void setImdb(Integer imdb) {
        this.imdb = imdb;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getMinute() {
        return minute;
    }

    public void setMinute(Date minute) {
        this.minute = minute;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Set<People> getDirected() {
        return directed;
    }

    public void setDirected(Set<People> directed) {
        this.directed = directed;
    }

    public Set<People> getWriter() {
        return writer;
    }

    public void setWriter(Set<People> writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover=" + cover +
                ", description='" + description + '\'' +
                ", imdb=" + imdb +
                ", creatdate=" + creatdate +
                ", country=" + country +
                ", minute=" + minute +
                ", category=" + category +
                ", directed=" + directed +
                ", writer=" + writer +
                '}';
    }
}
