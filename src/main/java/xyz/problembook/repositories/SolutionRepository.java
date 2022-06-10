package xyz.problembook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.problembook.dtos.Solution.SolutionDTO;
import xyz.problembook.entities.SolutionEntity;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<SolutionEntity, Integer> {
    @Query("select s from SolutionEntity s where s.userId = ?1")
    List<SolutionEntity> findAll(Integer userId);

    @Query("select new xyz.problembook.dtos.Solution.SolutionDTO(s.id, s.userId, u.name, s.problemId, s.answer, s.status, s.dateAdded) from SolutionEntity s join UserEntity u on s.userId = u.id where s.problemId = ?1")
    List<SolutionDTO> findAllByProblemId(Integer problemId);
}
