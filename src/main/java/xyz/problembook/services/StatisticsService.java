package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.problembook.dtos.Auth.RegisterDTO;
import xyz.problembook.dtos.Statistics.PerformerDTO;
import xyz.problembook.dtos.Statistics.StatisticsDTO;
import xyz.problembook.repositories.StatisticsRepository;
import xyz.problembook.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;
    private final UserRepository userRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository, UserRepository userRepository) {
        this.statisticsRepository = statisticsRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<StatisticsDTO> index(Integer userId) {
        StatisticsDTO statistics = new StatisticsDTO(
                statisticsRepository.getProblemsTotal(),
                statisticsRepository.getSolutionsTotal(),
                statisticsRepository.getMyCorrectSolutionsTotal(userId),
                statisticsRepository.getMySolutionsTotal(userId)
        );
        return ResponseEntity.ok(statistics);
    }

    public ResponseEntity<List<PerformerDTO>> topPerformers() {
        List<PerformerDTO> performers = userRepository.getTopPerformers();
        performers.sort(Comparator.comparing(p -> -p.correctSolutions));
        return ResponseEntity.ok(performers.stream().limit(5).collect(Collectors.toList()));
    }
}
