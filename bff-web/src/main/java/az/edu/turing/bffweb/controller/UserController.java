package az.edu.turing.bffweb.controller;

import az.edu.turing.bffweb.dto.UserDto;
import az.edu.turing.bffweb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bff-user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return service.getAll();

    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUseById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
