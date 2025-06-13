package com.stellants.usrmgmt.dto;



public class ProgramTypeDTO {

    private Long id;
    private String name;
    private String overview;

    public ProgramTypeDTO() {}

    public ProgramTypeDTO(Long id, String name, String overview) {
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

