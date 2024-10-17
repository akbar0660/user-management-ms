package az.edu.turing.bffweb.service;

import az.edu.turing.bffweb.client.BackendClient;
import az.edu.turing.bffweb.dto.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final BackendClient backendClient;

    @Override
    public ResponseEntity<ProfileDto> createProfile(Long userID, ProfileDto profileDto, MultipartFile file) {
        return backendClient.createProfile(userID, profileDto, file);
    }

    @Override
    public ResponseEntity<List<ProfileDto>> getAllByUserId(Long userId) {
        return backendClient.getAllProfiles(userId);
    }

    @Override
    public ResponseEntity<ProfileDto> getByUserIdAndProfileId(Long userId, Long profileId) {
        return backendClient.getProfileById(userId, profileId);
    }

    @Override
    public ResponseEntity<Void> deleteByUserIdAndProfileId(Long userId, Long profileId) {
        return backendClient.deleteProfileById(userId, profileId);
    }

    @Override
    public ResponseEntity<ProfileDto> updateProfilePicture(Long userId, Long profileId, byte[] profilePicture) {
        return backendClient.updateProfile(userId, profileId, profilePicture);
    }
}
