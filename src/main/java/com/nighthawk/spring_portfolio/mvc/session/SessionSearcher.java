package com.nighthawk.spring_portfolio.mvc.session;

import java.util.List;
import java.util.stream.Collectors;

public class SessionSearcher {
    public static List<SessionDTO> searchSessions(List<SessionDTO> sessions, String query) {
        String lowerCaseQuery = query.toLowerCase();
        return sessions.stream()
                .filter(session -> session.getDate().toLowerCase().contains(lowerCaseQuery) ||
                                   session.getName().toLowerCase().contains(lowerCaseQuery) ||
                                   session.getRole().toLowerCase().contains(lowerCaseQuery) ||
                                   session.getSubjects().toLowerCase().contains(lowerCaseQuery))
                .collect(Collectors.toList());
    }
}

