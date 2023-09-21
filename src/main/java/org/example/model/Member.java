package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "members")


public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "access_right")
    private boolean isEntranceAllowed;
    @Column(name = "flat_ownership")
    private Integer ownedApartmentsCount;
    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEntranceAllowed() {
        return isEntranceAllowed;
    }

    public void setEntranceAllowed(boolean entranceAllowed) {
        isEntranceAllowed = entranceAllowed;
    }

    public Integer getOwnedApartmentsCount() {
        return ownedApartmentsCount;
    }

    public void setOwnedApartmentsCount(Integer ownedApartmentsCount) {
        this.ownedApartmentsCount = ownedApartmentsCount;
    }


}