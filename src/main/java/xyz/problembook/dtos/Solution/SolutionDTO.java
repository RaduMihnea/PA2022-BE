package xyz.problembook.dtos.Solution;

public class SolutionDTO {
    public Integer userId;
    public Integer problemId;
    public String answer;

    public SolutionDTO(Integer userId, Integer problemId, String answer)
    {
        this.userId = userId;
        this.problemId = problemId;
        this.answer = answer;
    }
}
