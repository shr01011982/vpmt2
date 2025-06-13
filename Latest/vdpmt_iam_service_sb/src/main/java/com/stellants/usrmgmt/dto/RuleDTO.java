package com.stellants.usrmgmt.dto;


public class RuleDTO {

    private Long id;
    private String name;
    private String description;
    private String conditions;
    private String week;

    public RuleDTO() {}

    public RuleDTO(Long id, String name, String description, String conditions, String week) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.conditions = conditions;
        this.week = week;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
// Getters and Setters
}

