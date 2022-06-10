package xyz.problembook.dtos.Solution;

public class SolutionDTO {
    public Integer userId;
    public String userName;
    public Integer problemId;
    public String answer;
    public String status;
    public String dateAdded;

    public SolutionDTO(Integer userId, String userName, Integer problemId, String answer, String status, String dateAdded)
    {
        this.userId = userId;
        this.userName = userName;
        this.problemId = problemId;
        this.answer = answer;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    public SolutionDTO(Integer userId, Integer problemId, String answer)
    {
        this.userId = userId;
        this.problemId = problemId;
        this.answer = answer;
    }
}
