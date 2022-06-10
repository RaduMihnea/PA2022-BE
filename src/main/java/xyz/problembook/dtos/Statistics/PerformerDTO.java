package xyz.problembook.dtos.Statistics;

public class PerformerDTO {
    public String name;
    public String lastUpload;
    public Long totalSolutions;
    public Long correctSolutions;

    public PerformerDTO(String name, String lastUpload, Long totalSolutions, Long correctSolutions)
    {
        this.name = name;
        this.lastUpload = lastUpload;
        this.totalSolutions = totalSolutions;
        this.correctSolutions = correctSolutions;
    }
}
