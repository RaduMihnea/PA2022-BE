package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.problembook.dtos.ProblemAddDTO;
import xyz.problembook.dtos.ProblemDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.repositories.ProblemRepository;

import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public ResponseEntity<ProblemEntity> add(ProblemAddDTO problemDTO) {
        return new ResponseEntity<>(problemRepository.save(new ProblemEntity(problemDTO)), HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProblemDTO>> index() {
        return ResponseEntity.ok(problemRepository.findAllAggregated());
    }

    public ResponseEntity<ProblemDTO> show(Integer id)
    {
        return ResponseEntity.ok(problemRepository.getProblemById(id));
    }

    public ResponseEntity<?> destroy(Integer id) {
        problemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
