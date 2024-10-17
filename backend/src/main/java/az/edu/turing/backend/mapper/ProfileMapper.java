package az.edu.turing.backend.mapper;

import az.edu.turing.backend.entity.ProfileEntity;
import az.edu.turing.backend.model.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileEntity toProfileEntity(ProfileDto profileDto);

    ProfileDto toProfileDto(ProfileEntity profileEntity);

    List<ProfileEntity> toProfileEntityList(List<ProfileDto> profileDtoList);

    List<ProfileDto> toProfileDtoList(List<ProfileEntity> profileEntityList);
}
