package az.edu.turing.bffweb.service;

import az.edu.turing.bffweb.client.BackendClient;
import az.edu.turing.bffweb.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BackendClient backendClient;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto user) {
        return backendClient.createUser(user);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        return backendClient.getUsers();
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id) {
        return backendClient.getUseById(id);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return backendClient.deleteUser(id);
    }
}
