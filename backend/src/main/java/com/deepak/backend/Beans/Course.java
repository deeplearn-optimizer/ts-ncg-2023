package com.deepak.backend.Beans;

public class Course {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    private String title;
    private String description;
}
