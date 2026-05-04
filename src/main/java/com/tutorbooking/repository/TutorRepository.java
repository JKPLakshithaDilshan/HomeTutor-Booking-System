package com.tutorbooking.repository;

import com.tutorbooking.model.Tutor;
import com.tutorbooking.util.FileHelper;
import java.util.ArrayList;
import java.util.List;

public class TutorRepository {
    private static final String FILE_NAME = "tutors.txt";

    public List<Tutor> findAll() {
        List<String> lines = FileHelper.readAllLines(FILE_NAME);
        List<Tutor> tutors = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length >= 9) {
                tutors.add(new Tutor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], 
                                    Integer.parseInt(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8])));
            } else if (parts.length >= 7) {
                // Backward compatibility
                tutors.add(new Tutor(parts[0], parts[1], parts[2], parts[3], "", parts[4], 0, Double.parseDouble(parts[5]), 0.0));
            }
        }
        return tutors;
    }

    public void save(Tutor tutor) {
        FileHelper.appendLine(FILE_NAME, tutor.toString());
    }

    public boolean update(String id, Tutor tutor) {
        return FileHelper.updateRecordById(FILE_NAME, id, tutor.toString());
    }

    public boolean deleteById(String id) {
        return FileHelper.deleteRecordById(FILE_NAME, id);
    }

    public Tutor findById(String id) {
        return findAll().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Tutor findByEmail(String email) {
        return findAll().stream()
                .filter(t -> t.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
