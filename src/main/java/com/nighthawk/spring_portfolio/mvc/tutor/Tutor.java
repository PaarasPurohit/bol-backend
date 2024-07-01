package com.nighthawk.spring_portfolio.mvc.tutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "internship")
@NoArgsConstructor
public class Tutor {

    public static float sum(ArrayList<Integer> m) {
        float sum = 0;
        for(int i = 0; i < m.size(); i++)
            sum += m.get(i);
        return sum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private ArrayList<String> subjects;
    private ArrayList<Integer> ratings;
    private float averageRating;

    public Tutor(String username, String email, String password, ArrayList<String> subjects, ArrayList<Integer> ratings) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
        this.ratings = ratings;
        this.averageRating = sum(this.ratings) / this.ratings.size();
    }

    public static Tutor[] tutorInit() {
        Tutor t1 = new Tutor("Paaras Purohit", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));
        Tutor t2 = new Tutor("Emaad Mir", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));
        Tutor t3 = new Tutor("Rishi Bansal", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));
        Tutor t4 = new Tutor("Swarith Vaddi", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));
        Tutor t5 = new Tutor("Dinesh Sahai", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));
        Tutor t6 = new Tutor("Ankit Pullivendula", "email", "password", 
            new ArrayList<>(Arrays.asList("Math", "English", "Science", "History")), 
            new ArrayList<>(Arrays.asList(5)));

        return new Tutor[] {t1, t2, t3, t4, t5, t6};
    }

}
