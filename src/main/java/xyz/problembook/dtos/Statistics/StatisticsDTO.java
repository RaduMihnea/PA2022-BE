package xyz.problembook.dtos.Statistics;

public class StatisticsDTO {
    public Long problemsTotal;
    public Long solutionsTotal;
    public Long myCorrectSolutionsTotal;
    public Long mySolutionsTotal;

    public StatisticsDTO(Long problemsTotal, Long solutionsTotal, Long myCorrectSolutionsTotal, Long mySolutionsTotal)
    {
        this.problemsTotal = problemsTotal;
        this.solutionsTotal = solutionsTotal;
        this.myCorrectSolutionsTotal = myCorrectSolutionsTotal;
        this.mySolutionsTotal = mySolutionsTotal;
    }
}
