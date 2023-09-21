package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "flats_count")
    private Integer flatsCount;

    @OneToMany(mappedBy = "building")
    private List<Flat> flats;

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFlatsCount() {
        return flatsCount;
    }

    public void setFlatsCount(Integer flatsCount) {
        this.flatsCount = flatsCount;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }
}
