package university.rosbiotech.prototype1.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.rosbiotech.prototype1.dtos.UserDto;
import university.rosbiotech.prototype1.entities.User;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getFirst_name(), user.getLast_name());
    }
}
