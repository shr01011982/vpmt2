package com.stellants.usrmgmt.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "program_types")
public class ProgramType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 500)
    private String overview;

    public ProgramType() {}

    public ProgramType(Long id, String name, String overview) {
        this.id = id;
        this.name = name;
        this.overview = overview;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
// Getters and setters
}

