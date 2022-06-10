package xyz.problembook.dtos.Problem;

import lombok.Data;
import xyz.problembook.dtos.Solution.SolutionDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.entities.SolutionEntity;

import java.util.List;

@Data
public class ProblemDTO {

    public Integer id;

    public Integer teacherId;

    public String name;

    public String description;

    public String difficulty;

    public String answer;

    public String dateAdded;

    public List<SolutionDTO> solutions;

    public Long totalSolved;

    public Long totalCorrect;

    public ProblemDTO(Integer id, Integer teacherId, String name, String description, String difficulty, String dateAdded) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.answer = answer;
        this.dateAdded = dateAdded;
    }

    public ProblemDTO(Integer id, Integer teacherId, String name, String description, String difficulty, String dateAdded, Long totalSolved, Long totalCorrect) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.dateAdded = dateAdded;
        this.totalSolved = totalSolved;
        this.totalCorrect = totalCorrect;
    }

    public static ProblemDTO convert(ProblemEntity problemEntity) {
        return new ProblemDTO(problemEntity.getId(), problemEntity.getTeacherId(), problemEntity.getName(), problemEntity.getDescription(), problemEntity.getDifficulty(), problemEntity.getDateAdded());
    }
}
