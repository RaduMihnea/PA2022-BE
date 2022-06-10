package xyz.problembook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.problembook.dtos.Auth.LoginDTO;
import xyz.problembook.dtos.Auth.RegisterDTO;
import xyz.problembook.dtos.Auth.UserDTO;
import xyz.problembook.entities.UserEntity;
import xyz.problembook.services.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/register")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDTO registerDTO) throws NoSuchAlgorithmException {
        if(!Objects.equals(registerDTO.password, registerDTO.confirm))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return userService.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException {
        return userService.loginUser(loginDTO);
    }
}
