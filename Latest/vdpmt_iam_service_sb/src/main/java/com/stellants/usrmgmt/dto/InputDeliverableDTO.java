package com.stellants.usrmgmt.dto;


public class InputDeliverableDTO {
    private Long id;
    private String name;

    public InputDeliverableDTO() {}

    public InputDeliverableDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
