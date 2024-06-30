package cl.ucm.coffee.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private  Boolean disabled;
    private Boolean locked;

}
