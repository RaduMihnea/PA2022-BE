package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.problembook.dtos.Problem.ProblemAddDTO;
import xyz.problembook.dtos.Problem.ProblemDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.repositories.ProblemRepository;
import xyz.problembook.repositories.SolutionRepository;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final SolutionRepository solutionRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository, SolutionRepository solutionRepository) {
        this.problemRepository = problemRepository;
        this.solutionRepository = solutionRepository;
    }

    public ResponseEntity<ProblemEntity> add(ProblemAddDTO problemDTO) {
        return new ResponseEntity<>(problemRepository.save(new ProblemEntity(problemDTO)), HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProblemDTO>> index() {
        return ResponseEntity.ok(problemRepository.findAllAggregated());
    }

    public ResponseEntity<ProblemDTO> show(Integer id)
    {
        ProblemDTO problem = problemRepository.getProblemById(id);
        problem.setSolutions(solutionRepository.findAllByProblemId(id));
        return ResponseEntity.ok(problem);
    }

    public ResponseEntity<?> destroy(Integer id) {
        problemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
