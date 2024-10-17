package az.edu.turing.backend.mapper;

import az.edu.turing.backend.entity.UserEntity;
import az.edu.turing.backend.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

    List<UserEntity> toUserEntityList(List<UserDto> userDtoList);

    List<UserDto> toUserDtoList(List<UserEntity> userEntityList);
}
