package xyz.problembook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.problembook.dtos.ProblemAddDTO;
import xyz.problembook.dtos.ProblemDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.services.ProblemService;

import java.util.List;

@RestController
@RequestMapping(path = "problems")
public class ProblemController {
    private final ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProblemDTO>> index() {
        return problemService.index();
    }

    @PostMapping("/")
    public ResponseEntity<ProblemEntity> add(@RequestBody ProblemAddDTO problemDTO) {
        return problemService.add(problemDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProblemDTO> show(@PathVariable Integer id){return problemService.show(id);}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){return problemService.destroy(id);}
}
