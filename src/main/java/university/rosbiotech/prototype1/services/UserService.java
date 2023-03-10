package university.rosbiotech.prototype1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.rosbiotech.prototype1.dtos.UserDto;
import university.rosbiotech.prototype1.entities.Role;
import university.rosbiotech.prototype1.entities.Status;
import university.rosbiotech.prototype1.entities.User;
import university.rosbiotech.prototype1.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirst_name(userDto.getFirst_name());
        user.setLast_name(userDto.getLast_name());
        user.setPassword(user.getPassword());
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }
}
