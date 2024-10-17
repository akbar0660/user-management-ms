package az.edu.turing.backend.service;

import az.edu.turing.backend.entity.UserEntity;
import az.edu.turing.backend.model.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    List<UserDto> getAll();

    UserDto getById(Long id);

    void deleteById(Long id);
}
