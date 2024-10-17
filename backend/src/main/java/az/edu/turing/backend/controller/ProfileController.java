package az.edu.turing.backend.controller;

import az.edu.turing.backend.model.ProfileDto;
import az.edu.turing.backend.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v2/backend")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/users/{userId}/profiles")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProfileDto>> getAllProfiles(@PathVariable Long userId) {
        List<ProfileDto> profiles = profileService.getAllByUserId(userId);

        if (!profiles.isEmpty()) {
            return ResponseEntity.ok(profiles);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/users/{userId}/profiles", consumes = {"multipart/form-data"})
    public ResponseEntity<ProfileDto> createProfile(@PathVariable Long userId,
                                                    @Valid @RequestPart("profile") ProfileDto profileDto,
                                                    @RequestPart("profileImage") MultipartFile profileImage) throws IOException {
        byte[] bytes = profileImage.getBytes();
        profileDto.setProfileImage(bytes);
        ProfileDto profile = profileService.createProfile(userId, profileDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }

    @GetMapping("/users/{userId}/profiles/{profileId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long userId, @PathVariable Long profileId) {
        ProfileDto profileDto = profileService.getByUserIdAndProfileId(userId, profileId);
        if (profileDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profileDto);
    }

    @DeleteMapping("/users/{userId}/profiles/{profileId}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long userId, @PathVariable Long profileId) {
        profileService.deleteByUserIdAndProfileId(userId, profileId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/users/{userId}/profiles/{profileId}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long userId, @PathVariable Long profileId, @RequestPart("image") byte[] image) {
        ProfileDto profile = profileService.updateProfilePicture(userId, profileId, image);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        }
        return ResponseEntity.notFound().build();
    }

}
