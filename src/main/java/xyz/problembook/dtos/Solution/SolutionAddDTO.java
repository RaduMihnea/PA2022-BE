package xyz.problembook.dtos.Solution;

public class SolutionAddDTO {
    public Integer userId;
    public Integer problemId;
    public String answer;


    public SolutionAddDTO(Integer userId, Integer problemId, String answer)
    {
        this.userId = userId;
        this.problemId = problemId;
        this.answer = answer;
    }
}
