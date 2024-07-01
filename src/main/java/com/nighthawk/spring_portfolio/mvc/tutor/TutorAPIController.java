package com.nighthawk.spring_portfolio.mvc.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tutors")
@CrossOrigin(origins = "*")
public class TutorAPIController {

    private final TutorService tutorService;

    @Autowired
    public TutorAPIController(TutorService tutorService) {
        this.tutorService = tutorService;
    }
    
    // Get the entire database
    @GetMapping
    public ResponseEntity<List<TutorDTO>> getAllTutors() {
        List<Tutor> tutors = tutorService.getAllTutors();
        List<TutorDTO> tutorDTOs = tutors.stream()
                .map(tutor -> new TutorDTO(tutor))
                .collect(Collectors.toList());
        return new ResponseEntity<>(tutorDTOs, HttpStatus.OK);
    }
    
    // Get by a specific tutor
    @GetMapping("/{tutorId}")
    public ResponseEntity<TutorDTO> getTutorById(@PathVariable int tutorId) {
        Optional<Tutor> tutor = tutorService.getTutorById((long) tutorId);
        if (tutor.isPresent()) {
            TutorDTO tutorDTO = new TutorDTO(tutor.get());
            return ResponseEntity.ok().body(tutorDTO); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    // Create a new tutor account
    @PostMapping
    public ResponseEntity<TutorDTO> addTutor(@RequestBody TutorDTO tutorDTO) {
        Tutor tutor = new Tutor(
                tutorDTO.getUsername(),
                tutorDTO.getEmail(),
                tutorDTO.getPassword(),
                tutorDTO.getSubjects(), 
                tutorDTO.getRatings()
        );
        Tutor addedTutor = tutorService.createTutor(tutor);
        TutorDTO addedTutorDTO = new TutorDTO(addedTutor);
        return new ResponseEntity<>(addedTutorDTO, HttpStatus.CREATED);
    }
    
    // Delete a tutor account
    @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long tutorId) {
        tutorService.deleteTutor(tutorId);
        return ResponseEntity.noContent().build();
    }
}
