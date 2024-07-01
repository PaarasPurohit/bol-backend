package com.nighthawk.spring_portfolio.mvc.tutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TutorDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private ArrayList<String> subjects;
    private ArrayList<Integer> ratings;
    private float averageRating;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public float getAverageRating() {
        return Tutor.sum(this.ratings) / this.ratings.size();
    }

    // Constructor
    public TutorDTO(Long id, String username, String email, String password, ArrayList<String> subjects, int[] ratings, float averageRating) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
        this.ratings = Arrays.stream(ratings).boxed().collect(Collectors.toCollection(ArrayList::new));
        this.averageRating = averageRating;
    }

    // No-args Constructor
    public TutorDTO() {
    }

    public TutorDTO(Tutor tutor) {
        this.id = tutor.getId();
        this.username = tutor.getUsername();
        this.email = tutor.getEmail();
        this.subjects = tutor.getSubjects();
        this.ratings = tutor.getRatings();
        this.averageRating = tutor.getAverageRating();
    }
}
