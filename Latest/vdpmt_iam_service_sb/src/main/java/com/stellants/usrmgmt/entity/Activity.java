package com.stellants.usrmgmt.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "rasi_cat_id", nullable = false)
    private RasiCategory rasiCategory;

    public Activity() {}

    public Activity(Long id, String name, RasiCategory rasiCategory) {
        this.id = id;
        this.name = name;
        this.rasiCategory = rasiCategory;
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

    public RasiCategory getRasiCategory() {
        return rasiCategory;
    }

    public void setRasiCategory(RasiCategory rasiCategory) {
        this.rasiCategory = rasiCategory;
    }
// Getters and Setters
}

