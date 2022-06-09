package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.problembook.dtos.SolutionDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.entities.SolutionEntity;
import xyz.problembook.repositories.ProblemRepository;
import xyz.problembook.repositories.SolutionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolutionService {

    private final SolutionRepository solutionRepository;

    private final ProblemRepository problemRepository;


    @Autowired
    public SolutionService(SolutionRepository solutionRepository, ProblemRepository problemRepository) {
        this.solutionRepository = solutionRepository;
        this.problemRepository = problemRepository;
    }

    public ResponseEntity<SolutionEntity> add(SolutionDTO solutionDTO) {
        ProblemEntity problem = this.problemRepository.findById(solutionDTO.problemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Referenced problem not found"));
        SolutionEntity solution = solutionRepository.saveAndFlush(new SolutionEntity(solutionDTO, problem.getAnswer()));
        return new ResponseEntity<>(solutionRepository.save(solution), HttpStatus.CREATED);
    }

    public List<SolutionEntity> index(Integer userId){
        return solutionRepository.findAll(userId);
    }

    public void destroy(Integer id){
        solutionRepository.deleteById(id);
    }
}
