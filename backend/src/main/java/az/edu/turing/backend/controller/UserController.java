package az.edu.turing.backend.controller;

import az.edu.turing.backend.model.UserDto;
import az.edu.turing.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/backend")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> users = service.getAll();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        if (service.createUser(userDto) != null) {
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUseById(@PathVariable Long id) {
        UserDto user = service.getById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}