package xyz.problembook.dtos.Problem;

import lombok.Data;
import xyz.problembook.entities.ProblemEntity;

@Data
public class ProblemAddDTO {

    public Integer teacherId;

    public String name;

    public String description;

    public String difficulty;

    public String answer;

    public ProblemAddDTO(Integer teacherId, String name, String description, String difficulty, String answer) {
        this.teacherId = teacherId;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.answer = answer;
    }
}
