package xyz.problembook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.problembook.dtos.Statistics.StatisticsDTO;
import xyz.problembook.services.StatisticsService;

@RestController
@RequestMapping("statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StatisticsDTO> index(@PathVariable Integer userId){
        return statisticsService.index(userId);
    }
}
