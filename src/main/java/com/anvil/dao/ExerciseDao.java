package com.anvil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anvil.model.Exercise;
import java.util.List;


@Repository
public interface ExerciseDao extends JpaRepository <Exercise, Integer> {
    List<Exercise> findAllByName(String name);

    List<Exercise> findAllByMuscleGroup(String muscleGroup);

    List<Exercise> findAllByEquipmentContaining(String equipment);

    List<Exercise> findAllByDifficulty(int difficulty);
    
}
