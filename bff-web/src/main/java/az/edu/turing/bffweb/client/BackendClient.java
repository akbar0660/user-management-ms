package az.edu.turing.bffweb.client;

import az.edu.turing.bffweb.dto.ProfileDto;
import az.edu.turing.bffweb.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "backend", url = "http://localhost:8080")
public interface BackendClient {

    @GetMapping("/api/v1/backend/users")
    ResponseEntity<List<UserDto>> getUsers();

    @PostMapping("/api/v1/backend/users")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

    @GetMapping("/api/v1/backend/users/{id}")
    ResponseEntity<UserDto> getUseById(@PathVariable Long id);

    @DeleteMapping("/api/v1/backend/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

    @GetMapping("/api/v2/backend/users/{userId}/profiles")
    ResponseEntity<List<ProfileDto>> getAllProfiles(@PathVariable Long userId);

    @PostMapping(value = "/api/v2/backend/users/{userId}/profiles", consumes = {"multipart/form-data"})
    ResponseEntity<ProfileDto> createProfile(@PathVariable Long userId,
                                             @Valid @RequestPart("profile") ProfileDto profileDto,
                                             @RequestPart("profileImage") MultipartFile profileImage);

    @GetMapping("/api/v2/backend/users/{userId}/profiles/{profileId}")
    ResponseEntity<ProfileDto> getProfileById(@PathVariable Long userId, @PathVariable Long profileId);

    @DeleteMapping("/api/v2/backend/users/{userId}/profiles/{profileId}")
    ResponseEntity<Void> deleteProfileById(@PathVariable Long userId, @PathVariable Long profileId);

    @PatchMapping("/api/v2/backend/users/{userId}/profiles/{profileId}")
    ResponseEntity<ProfileDto> updateProfile(@PathVariable Long userId, @PathVariable Long profileId, @RequestPart("image") byte[] image);


}