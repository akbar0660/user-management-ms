package az.edu.turing.bffweb.service;

import az.edu.turing.bffweb.dto.ProfileDto;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfileService {
    ResponseEntity<ProfileDto> createProfile(Long userID, ProfileDto profileDto, MultipartFile file);

    ResponseEntity<List<ProfileDto>> getAllByUserId(Long userId);

    ResponseEntity<ProfileDto> getByUserIdAndProfileId(Long userId, Long profileId);

    ResponseEntity<Void> deleteByUserIdAndProfileId(Long userId, Long profileId);

    ResponseEntity<ProfileDto> updateProfilePicture(Long userId, Long profileId, byte[] profilePicture);
}
