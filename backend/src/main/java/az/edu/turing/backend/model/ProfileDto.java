package az.edu.turing.backend.model;

import az.edu.turing.backend.model.enums.MediaType;
import az.edu.turing.backend.model.enums.ProfileStatus;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
