package com.stellants.usrmgmt.dto;



public class ActivityDTO {

    private Long id;
    private String name;
    private Long rasiCatId;
    private String rasiActivityName;

    public ActivityDTO() {}

    public ActivityDTO(Long id, String name, Long rasiCatId, String rasiActivityName) {
        this.id = id;
        this.name = name;
        this.rasiCatId = rasiCatId;
        this.rasiActivityName = rasiActivityName;
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

    public Long getRasiCatId() {
        return rasiCatId;
    }

    public void setRasiCatId(Long rasiCatId) {
        this.rasiCatId = rasiCatId;
    }

    public String getRasiActivityName() {
        return rasiActivityName;
    }

    public void setRasiActivityName(String rasiActivityName) {
        this.rasiActivityName = rasiActivityName;
    }
// Getters and Setters
}

