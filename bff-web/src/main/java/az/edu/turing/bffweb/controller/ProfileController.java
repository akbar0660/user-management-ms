package az.edu.turing.bffweb.controller;

import az.edu.turing.bffweb.dto.ProfileDto;
import az.edu.turing.bffweb.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/bff-profile/")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/users/{userId}/profiles")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProfileDto>> getAllProfiles(@PathVariable Long userId) {
        return profileService.getAllByUserId(userId);
    }

    @PostMapping(value = "/users/{userId}/profiles", consumes = {"multipart/form-data"})
    public ResponseEntity<ProfileDto> createProfile(@PathVariable Long userId,
                                                    @Valid @RequestPart("profile") ProfileDto profileDto,
                                                    @RequestPart("profileImage") MultipartFile profileImage) throws IOException {
        return profileService.createProfile(userId, profileDto, profileImage);
    }

    @GetMapping("/users/{userId}/profiles/{profileId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long userId, @PathVariable Long profileId) {
        return profileService.getByUserIdAndProfileId(userId, profileId);
    }

    @DeleteMapping("/users/{userId}/profiles/{profileId}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable Long userId, @PathVariable Long profileId) {
        return profileService.deleteByUserIdAndProfileId(userId, profileId);
    }

    @PatchMapping("/users/{userId}/profiles/{profileId}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long userId, @PathVariable Long profileId, @RequestPart("image") byte[] image) {
        return profileService.updateProfilePicture(userId, profileId, image);
    }

}
