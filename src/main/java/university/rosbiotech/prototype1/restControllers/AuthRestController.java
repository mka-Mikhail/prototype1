package university.rosbiotech.prototype1.restControllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import university.rosbiotech.prototype1.configs.JwtTokenUtils;
import university.rosbiotech.prototype1.dtos.AuthRequestDto;
import university.rosbiotech.prototype1.entities.User;
import university.rosbiotech.prototype1.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthRestController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
            User user = userService.findByEmail(authRequestDto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User does`t exist"));
            String token = jwtTokenUtils.createToken(authRequestDto.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", authRequestDto.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
