package xyz.problembook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.problembook.entities.SolutionEntity;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<SolutionEntity, Integer> {
    @Query("select s from SolutionEntity s where s.userId = ?1")
    List<SolutionEntity> findAll(Integer userId);
}
