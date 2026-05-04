package com.tutorbooking.service;

import com.tutorbooking.model.Tutor;
import com.tutorbooking.repository.TutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository = new TutorRepository();

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor getTutorById(String id) {
        return tutorRepository.findById(id);
    }

    public Tutor getTutorByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

    public void addTutor(Tutor tutor) {
        tutorRepository.save(tutor);
    }

    public void updateTutor(String id, Tutor tutor) {
        tutorRepository.update(id, tutor);
    }

    public void removeTutor(String id) {
        tutorRepository.deleteById(id);
    }

    public boolean deleteTutor(String id) {
        return tutorRepository.deleteById(id);
    }

    public Tutor authenticate(String email, String password) {
        Tutor tutor = tutorRepository.findByEmail(email);
        if (tutor != null && tutor.getPassword().equals(password)) {
            return tutor;
        }
        return null;
    }
}
