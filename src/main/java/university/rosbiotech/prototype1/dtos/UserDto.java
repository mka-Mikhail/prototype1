package university.rosbiotech.prototype1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import university.rosbiotech.prototype1.entities.Permission;
import university.rosbiotech.prototype1.entities.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private Permission role;
    private Status status;

    public UserDto(Long id, String email, String password, String first_name, String last_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UserDto(Long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
}
