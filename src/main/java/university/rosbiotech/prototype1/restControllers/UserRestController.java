package university.rosbiotech.prototype1.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.rosbiotech.prototype1.dtos.UserDto;
import university.rosbiotech.prototype1.entities.User;
import university.rosbiotech.prototype1.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    @PreAuthorize(value = "hasAuthority('write')")
    public List<UserDto> getAll() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : userService.getAll()) {
            UserDto userDto = new UserDto(user.getId(), user.getFirst_name(), user.getLast_name());
            usersDto.add(userDto);
        }
        return usersDto;
    }
}
