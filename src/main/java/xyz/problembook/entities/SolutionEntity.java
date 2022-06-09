package xyz.problembook.entities;

import lombok.*;
import xyz.problembook.dtos.RegisterDTO;
import xyz.problembook.dtos.SolutionDTO;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class describing the 'users' table in the database.
 * The email is guaranteed to be a valid one.
 * The 'avatar_id' can take a finite amount of values, depending on how many avatars are in the database.
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "solutions")
public class SolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="problem_id")
    private Integer problemId;

    @Column
    private String answer;

    @Column
    private Boolean correct;

    public SolutionEntity(SolutionDTO data, String realAnswer) {
        this.userId = data.userId;
        this.problemId = data.problemId;
        this.answer = data.answer;
        this.correct = data.answer.equals(realAnswer);
    }
}
