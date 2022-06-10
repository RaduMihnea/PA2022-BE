package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.problembook.dtos.Auth.RegisterDTO;
import xyz.problembook.dtos.Statistics.StatisticsDTO;
import xyz.problembook.repositories.StatisticsRepository;


@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public ResponseEntity<StatisticsDTO> index(Integer userId){
        StatisticsDTO statistics = new StatisticsDTO(
                statisticsRepository.getProblemsTotal(),
                statisticsRepository.getSolutionsTotal(),
                statisticsRepository.getMyCorrectSolutionsTotal(userId),
                statisticsRepository.getMySolutionsTotal(userId)
        );
        return ResponseEntity.ok(statistics);
    }
}
