package com.anvil.model;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Exercise {
    private int id;
    private String name;
    private String muscleGroup;
    private List<String> equipment;
    private String difficulty;
    private String imageUrl;
}
