package xyz.problembook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.problembook.dtos.Statistics.PerformerDTO;
import xyz.problembook.dtos.Statistics.StatisticsDTO;
import xyz.problembook.services.StatisticsService;

import java.util.List;

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

    @GetMapping("/top-performers")
    public ResponseEntity<List<PerformerDTO>> index(){
        return statisticsService.topPerformers();
    }
}
