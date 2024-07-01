package com.nighthawk.spring_portfolio.mvc.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorJPARepository tutorRepository;

    @Autowired
    public TutorService(TutorJPARepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> getTutorById(Long tutorId) {
        return tutorRepository.findById(tutorId);
    }

    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void deleteTutor(Long tutorId) {
        tutorRepository.deleteById(tutorId);
    }
}