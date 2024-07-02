package com.nighthawk.spring_portfolio.mvc.session;

import java.util.ArrayList;
import java.util.Arrays;

import com.nighthawk.spring_portfolio.mvc.tutor.Tutor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "session")
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String name;
    private String role;
    private String subjects;

    public Session(String date, String name, String role, String subjects) {
        this.date = date;
        this.name = name;
        this.role = role;
        this.subjects = subjects;
    }
    
    public static Session[] sessionInit() {
        Session s1 = new Session ("7/7", "Paaras Purohit", "Tutor", "Math, English, Science, History");

        return new Session[] {s1};
    }
}
