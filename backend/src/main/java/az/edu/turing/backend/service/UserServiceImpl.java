package az.edu.turing.backend.service;

import az.edu.turing.backend.entity.UserEntity;
import az.edu.turing.backend.mapper.UserMapper;
import az.edu.turing.backend.model.UserDto;
import az.edu.turing.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public UserDto createUser(UserDto user) {
        if (user != null) {
            return mapper.toUserDto(userRepository.save(mapper.toUserEntity(user)));
        } else {
            throw new RuntimeException("User can't be null");
        }
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto getById(Long id) {
        if (id != null) {
            UserEntity userEntity = userRepository.findById(id).orElse(null);
            if (userEntity != null) {
                return mapper.toUserDto(userEntity);
            } else {
                throw new RuntimeException("User not found");
            }
        } else {
            throw new RuntimeException("Id can't be null");
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id can't be null");
        }
    }
}
