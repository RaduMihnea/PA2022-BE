package xyz.problembook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.problembook.dtos.Statistics.PerformerDTO;
import xyz.problembook.entities.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("select u from UserEntity u where u.email = ?1")
    Optional<UserEntity> findByEmail(String email);

    @Query("select new xyz.problembook.dtos.Statistics.PerformerDTO(" +
            "u.name," +
            "(select max(s.dateAdded) from SolutionEntity s where s.userId = u.id)," +
            "(select count(s.answer) from SolutionEntity s where s.userId = u.id)," +
            "(select count(s.answer) from SolutionEntity s where s.userId = u.id and s.status='correct')" +
            ") from UserEntity u")
    List<PerformerDTO> getTopPerformers();
}
