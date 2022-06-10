package xyz.problembook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.problembook.dtos.Statistics.StatisticsDTO;
import xyz.problembook.entities.SolutionEntity;
import xyz.problembook.entities.UserEntity;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<SolutionEntity, Integer> {
    @Query("select count(s) from SolutionEntity s")
    Long getProblemsTotal();

    @Query("select count(s.answer) from SolutionEntity s")
    Long getSolutionsTotal();

    @Query("select count(s) from SolutionEntity s where s.status = 'correct' and s.userId = ?1")
    Long getMyCorrectSolutionsTotal(Integer userId);

    @Query("select count(s) from SolutionEntity s where s.userId = ?1")
    Long getMySolutionsTotal(Integer userId);
}
