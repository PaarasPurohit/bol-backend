package com.nighthawk.spring_portfolio.mvc.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionAPIController {

    private final SessionService sessionService;

    @Autowired
    public SessionAPIController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    
    // Get the entire database
    @GetMapping
    public ResponseEntity<List<SessionDTO>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDTO> sessionDTOs = sessions.stream()
                .map(session -> new SessionDTO(session))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sessionDTOs, HttpStatus.OK);
    }
    
    // Get by a specific session
    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable int sessionId) {
        Optional<Session> session = sessionService.getSessionById((long) sessionId);
        if (session.isPresent()) {
            SessionDTO sessionDTO = new SessionDTO(session.get());
            return ResponseEntity.ok().body(sessionDTO); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<SessionDTO>> getSearchedSessions(@RequestParam String query) {
        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDTO> sessionDTOs = sessions.stream()
                .map(SessionDTO::new)
                .collect(Collectors.toList());
        List<SessionDTO> searched = SessionSearcher.searchSessions(sessionDTOs, query);
        return new ResponseEntity<>(searched, HttpStatus.OK);
    }
    
    
    // Create a new session account
    @PostMapping
    public ResponseEntity<SessionDTO> addSession(@RequestBody SessionDTO sessionDTO) {
        Session session = new Session(
                sessionDTO.getDate(),
                sessionDTO.getName(),
                sessionDTO.getRole(),
                sessionDTO.getSubjects()
        );
        Session addedSession = sessionService.createSession(session);
        SessionDTO addedSessionDTO = new SessionDTO(addedSession);
        return new ResponseEntity<>(addedSessionDTO, HttpStatus.CREATED);
    }
    
    // Delete a session account
    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long sessionId) {
        sessionService.deleteSession(sessionId);
        return ResponseEntity.noContent().build();
    }
}
