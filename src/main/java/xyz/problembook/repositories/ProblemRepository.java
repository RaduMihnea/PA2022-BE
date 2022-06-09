package xyz.problembook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.problembook.dtos.ProblemDTO;
import xyz.problembook.entities.ProblemEntity;
import xyz.problembook.entities.SolutionEntity;
import xyz.problembook.entities.UserEntity;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<ProblemEntity, Integer> {
    @Query("select new xyz.problembook.dtos.ProblemDTO(t.id, t.teacherId, t.name, t.description, t.difficulty, t.dateAdded, (select COUNT(*) from SolutionEntity s where s.problemId = t.id), (select COUNT(*) from SolutionEntity s where s.problemId = t.id and correct = true)) from ProblemEntity t")
    List<ProblemDTO> findAllAggregated();

    @Query("select new xyz.problembook.dtos.ProblemDTO(t.id, t.teacherId, t.name, t.description, t.difficulty, t.dateAdded) from ProblemEntity t where t.id = ?1")
    ProblemDTO getProblemById(Integer id);
}
