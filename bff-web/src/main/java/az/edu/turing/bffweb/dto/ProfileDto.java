package az.edu.turing.bffweb.dto;

import az.edu.turing.bffweb.dto.enums.MediaType;
import az.edu.turing.bffweb.dto.enums.ProfileStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProfileDto {
    @NotBlank
    private String userName;

    @NotBlank
    private ProfileStatus status;

    @NotBlank
    private MediaType mediaType;

    private byte[] profileImage;
}
