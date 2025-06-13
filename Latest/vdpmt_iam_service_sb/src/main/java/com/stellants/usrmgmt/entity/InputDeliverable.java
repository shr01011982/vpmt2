package com.stellants.usrmgmt.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "input_deliverables")
public class InputDeliverable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    public InputDeliverable() {}

    public InputDeliverable(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
