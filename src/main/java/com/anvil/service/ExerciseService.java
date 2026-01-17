package com.anvil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.anvil.dao.ExerciseDao;
import com.anvil.model.Exercise;

@Service
public class ExerciseService {
    
    @Autowired
    ExerciseDao exerciseDao;

    public ResponseEntity<Exercise> addExercise(Exercise exercise) {
        Exercise savedExercise = exerciseDao.save(exercise);
        return ResponseEntity.ok(savedExercise);
    }

    public ResponseEntity<Exercise> getExerciseById(int id) {
        Exercise exercise = exerciseDao.findById(id).orElse(null);
        if (exercise != null) {
            return ResponseEntity.ok(exercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
