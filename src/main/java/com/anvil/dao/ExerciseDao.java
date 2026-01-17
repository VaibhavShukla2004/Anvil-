package com.anvil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anvil.model.Exercise;

@Repository
public interface ExerciseDao extends JpaRepository <Exercise, Integer> {
    
}
