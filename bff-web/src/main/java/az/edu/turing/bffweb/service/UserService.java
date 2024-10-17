package az.edu.turing.bffweb.service;

import az.edu.turing.bffweb.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<UserDto> createUser(UserDto user);

    ResponseEntity<List<UserDto>> getAll();

    ResponseEntity<UserDto> getById(Long id);

    ResponseEntity<Void> deleteById(Long id);
}
