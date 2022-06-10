package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.problembook.dtos.Solution.SolutionAddDTO;
import xyz.problembook.dtos.Solution.SolutionDTO;
import xyz.problembook.dtos.Solution.SolutionUpdateDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.entities.SolutionEntity;
import xyz.problembook.repositories.ProblemRepository;
import xyz.problembook.repositories.SolutionRepository;

import java.util.List;

@Service
public class SolutionService {

    private final SolutionRepository solutionRepository;

    private final ProblemRepository problemRepository;


    @Autowired
    public SolutionService(SolutionRepository solutionRepository, ProblemRepository problemRepository) {
        this.solutionRepository = solutionRepository;
        this.problemRepository = problemRepository;
    }

    public ResponseEntity<SolutionEntity> add(SolutionAddDTO solutionDTO) {
        ProblemEntity problem = this.problemRepository.findById(solutionDTO.problemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Referenced problem not found"));
        SolutionEntity solution = solutionRepository.saveAndFlush(new SolutionEntity(solutionDTO));
        return new ResponseEntity<>(solutionRepository.save(solution), HttpStatus.CREATED);
    }

    public List<SolutionEntity> index(Integer userId){
        return solutionRepository.findAll(userId);
    }

    public ResponseEntity<SolutionEntity> update(Integer id, SolutionUpdateDTO solutionUpdateDTO) {
        SolutionEntity solution = solutionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Referenced solution not found"));
        solution.setStatus(solutionUpdateDTO.verdict);
        return new ResponseEntity<>(solutionRepository.save(solution), HttpStatus.CREATED);
    }

    public void destroy(Integer id){
        solutionRepository.deleteById(id);
    }
}
