package xyz.problembook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.problembook.dtos.Solution.SolutionAddDTO;
import xyz.problembook.entities.SolutionEntity;
import xyz.problembook.services.SolutionService;

import java.util.List;

@RestController
@RequestMapping(path = "solutions")
public class SolutionController {
    private final SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/")
    public List<SolutionEntity> index(@RequestBody Integer userId) {
        return solutionService.index(userId);
    }

    @PostMapping("/")
    public ResponseEntity<SolutionEntity> add(@RequestBody SolutionAddDTO solutionDTO) {
        return solutionService.add(solutionDTO);
    }

    @PatchMapping(value = "/{id}", consumes="text/plain")
    public ResponseEntity<SolutionEntity> update(@PathVariable Integer id, @RequestBody String status){
        return solutionService.update(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){solutionService.destroy(id);}
}
