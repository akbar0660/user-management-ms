package az.edu.turing.backend.service;

import az.edu.turing.backend.model.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto createProfile(Long userID, ProfileDto profileDto);

    List<ProfileDto> getAllByUserId(Long userId);

    ProfileDto getByUserIdAndProfileId(Long userId, Long profileId);

    void deleteByUserIdAndProfileId(Long userId, Long profileId);

    ProfileDto updateProfilePicture(Long userId, Long profileId, byte[] profilePicture);
}
