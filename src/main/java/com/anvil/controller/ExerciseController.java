package com.anvil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.model.Exercise;
import com.anvil.service.ExerciseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    // GET MAPPINGS
    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable int id) {
        Exercise ex = exerciseService.getExerciseById(id);
        return ex != null ? ResponseEntity.ok(ex) : ResponseEntity.notFound().build();

    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<Exercise>> getExercisesByName(@PathVariable String name) {
        return ResponseEntity.ok(exerciseService.getExerciseByName(name));
    }

    @GetMapping("muscleGroup/{muscleGroup}")
    public ResponseEntity<List<Exercise>> getExercisesByMuscleGroup(@PathVariable String muscleGroup) {
        return ResponseEntity.ok(exerciseService.getExerciseByMuscleGroup(muscleGroup));
    }

    @GetMapping("equipment/{equipment}")
    public ResponseEntity<List<Exercise>> getExercisesByEquipment(@PathVariable String equipment) {
        return ResponseEntity.ok(exerciseService.getExerciseByEquipment(equipment));
    }

    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<Exercise>> getExercisesByDifficulty(@PathVariable int difficulty) {
        return ResponseEntity.ok(exerciseService.getExerciseByDifficulty(difficulty));
    }

    // PUT/UPDATE MAPPING
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> putExercise(
            @PathVariable int id,
            @RequestBody Exercise exercise) {
        exercise.setId(id);
        return ResponseEntity.ok(exerciseService.updateExercise(exercise));
    }

    // DELETE MAPPINGS
    @DeleteMapping("id/{id}")
    public ResponseEntity<Exercise> deleteExerciseById(@PathVariable int id) {
        return ResponseEntity.ok(exerciseService.deleteExerciseById(id));
    }

    @DeleteMapping
    public ResponseEntity<List<Exercise>> deleteAllExercises() {
        return ResponseEntity.ok(exerciseService.deleteAllExercises());
    }

    // POST MAPPING
    @PostMapping
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.addExercise(exercise));
    }

}
