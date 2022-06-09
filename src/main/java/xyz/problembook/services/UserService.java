package xyz.problembook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.problembook.dtos.LoginDTO;
import xyz.problembook.dtos.RegisterDTO;
import xyz.problembook.dtos.UserDTO;
import xyz.problembook.entities.UserEntity;
import xyz.problembook.repositories.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserEntity> registerUser(RegisterDTO registerDTO) throws NoSuchAlgorithmException {
        userRepository.findByEmail(registerDTO.email).ifPresent(s -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with that email already exists!");
        });

        UserEntity user = userRepository.save(new UserEntity(registerDTO));

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public ResponseEntity<UserDTO> loginUser(LoginDTO loginDTO) throws NoSuchAlgorithmException {
        UserEntity user = userRepository.findByEmail(loginDTO.email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with that email not found"));

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(loginDTO.password.getBytes());
        String stringHash = new String(messageDigest.digest());

        if (stringHash.equals(user.getPassword()))
            return ResponseEntity.ok(user.fromEntityToDto());
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
