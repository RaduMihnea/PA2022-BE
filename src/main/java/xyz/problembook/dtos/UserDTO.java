package xyz.problembook.dtos;

public class UserDTO {
    public String user;
    public String role;
    public Integer id;

    public UserDTO(String user, String role, Integer id)
    {
        this.user = user;
        this.role = role;
        this.id = id;
    }
}
