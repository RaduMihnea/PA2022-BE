package xyz.problembook.entities;

import lombok.*;
import xyz.problembook.dtos.RegisterDTO;
import xyz.problembook.dtos.UserDTO;

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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    public UserEntity(RegisterDTO data) throws NoSuchAlgorithmException {
        this.name = data.name;
        this.email = data.email;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(data.password.getBytes());
        String stringHash = new String(messageDigest.digest());
        this.password = stringHash;
        this.role = data.role;
    }

    public UserDTO fromEntityToDto()
    {
        return new UserDTO(
                name,
                role,
                id
        );
    }
}
