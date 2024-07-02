package com.nighthawk.spring_portfolio.mvc.session;

public class SessionDTO {

    private Long id;
    private String date;
    private String name;
    private String role;
    private String subjects;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    // Constructors
    public SessionDTO() {
    }

    public SessionDTO(Long id, String date, String name, String role, String subjects) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.role = role;
        this.subjects = subjects;
    }

    public SessionDTO(Session session) {
        this.id = session.getId();
        this.date = session.getDate();
        this.name = session.getName();
        this.role = session.getRole();
        this.subjects = session.getSubjects();
    }
}
