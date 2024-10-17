package az.edu.turing.backend.service;

import az.edu.turing.backend.entity.ProfileEntity;
import az.edu.turing.backend.entity.UserEntity;
import az.edu.turing.backend.mapper.ProfileMapper;
import az.edu.turing.backend.model.ProfileDto;
import az.edu.turing.backend.repository.ProfileRepository;
import az.edu.turing.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper mapper = ProfileMapper.INSTANCE;

    @Override
    public ProfileDto createProfile(Long userId, ProfileDto profileDto) {
        if (userId != null && profileDto != null) {
            UserEntity user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                ProfileEntity profileEntity = mapper.toProfileEntity(profileDto);
                profileEntity.setUser(user);
                return mapper.toProfileDto(profileRepository.save(profileEntity));
            }
            throw new RuntimeException("User not found");
        }
        throw new RuntimeException("Profile can not be empty");
    }

    @Override
    public List<ProfileDto> getAllByUserId(Long userId) {
        if (userId != null) {
            return mapper.toProfileDtoList(profileRepository.findByUserId(userId));
        }
        throw new RuntimeException("User id can not be empty");
    }

    @Override
    public ProfileDto getByUserIdAndProfileId(Long userId, Long profileId) {
        if (userId != null && profileId != null) {
             profileRepository.findByIdAndUserId(profileId, userId).ifPresent(profile -> mapper.toProfileDto(profile));
        }
        throw new RuntimeException("Profile and user id can not be empty");
    }


    @Override
    public void deleteByUserIdAndProfileId(Long userId, Long profileId) {
        if (userId != null && profileId != null) {
            profileRepository.deleteByIdAndUserId(profileId, userId);
        }
        throw new RuntimeException("Profile and user id can not be empty");
    }

    @Override
    public ProfileDto updateProfilePicture(Long userId, Long profileId, byte[] profilePicture) {
        Optional<ProfileEntity> optionalProfile = profileRepository.findByIdAndUserId(profileId, userId);

        if (optionalProfile.isPresent()) {
            ProfileEntity profile = optionalProfile.get();
            profile.setProfileImage(profilePicture);
            return mapper.toProfileDto(profileRepository.save(profile));
        } else {
            throw new RuntimeException("Profile not found for userId: " + userId + " and profileId: " + profileId);
        }
    }
}
