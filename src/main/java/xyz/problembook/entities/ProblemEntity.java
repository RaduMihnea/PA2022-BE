package xyz.problembook.entities;

import lombok.*;
import xyz.problembook.dtos.ProblemAddDTO;
import xyz.problembook.dtos.ProblemDTO;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Class describing the 'problem' table from the database.
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "problems")
public class ProblemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column
    private Integer teacherId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String answer;

    @Column
    private String difficulty;

    @Column
    private String dateAdded;

    public ProblemEntity(ProblemAddDTO data)
    {
        this.teacherId = data.teacherId;
        this.name = data.name;
        this.description = data.description;
        this.difficulty = data.difficulty;
        this.answer = data.answer;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                .withZone(ZoneId.systemDefault());
        Instant instant = Instant.now();
        this.dateAdded = formatter.format(instant);
    }
}
