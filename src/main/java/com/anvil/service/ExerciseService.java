package com.anvil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anvil.dao.ExerciseDao;
import com.anvil.model.Exercise;

import jakarta.transaction.Transactional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    // CREATE
    public Exercise addExercise(Exercise exercise) {
        return exerciseDao.save(exercise);
    }

    // UPDATE
    public Exercise updateExercise(Exercise exercise) {
        return exerciseDao.save(exercise);
    }

    // READ
    public Exercise getExerciseById(int id) {
        return exerciseDao.findById(id).orElse(null);
    }

    public List<Exercise> getExerciseByName(String name) {
        return exerciseDao.findAllByName(name);
    }

    public List<Exercise> getExerciseByMuscleGroup(String muscleGroup) {
        return exerciseDao.findAllByMuscleGroup(muscleGroup);
    }

    public List<Exercise> getExerciseByEquipment(String equipment) {
        return exerciseDao.findAllByEquipmentContaining(equipment);
    }

    public List<Exercise> getExerciseByDifficulty(int difficulty) {
        if (difficulty < 1 || difficulty > 5) {
            throw new IllegalArgumentException("Difficulty must be between 1 and 5");
        }
        return exerciseDao.findAllByDifficulty(difficulty);
    }

    public List<Exercise> getAllExercises() {
        return exerciseDao.findAll();
    }

    // DELETE
    @Transactional
    public Exercise deleteExerciseById(int id) {
        Exercise exercise = exerciseDao.findById(id).orElse(null);
        if (exercise != null) {
            exerciseDao.deleteById(id);
        }
        return exercise;
    }

    @Transactional
    public List<Exercise> deleteAllExercises() {
        List<Exercise> exercises = exerciseDao.findAll();
        exerciseDao.deleteAll();
        return exercises;
    }
}

