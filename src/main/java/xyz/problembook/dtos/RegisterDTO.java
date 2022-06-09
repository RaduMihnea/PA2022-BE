package xyz.problembook.dtos;

/**
 * Class that represent information received upon registering.
 * Work for both Student and Teacher registration.
 */
public class RegisterDTO {
    public String name;
    public String email;
    public String password;
    public String confirm;
    public String role;

    public RegisterDTO(String name, String email, String password, String confirm, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.role = role;
    }
}
