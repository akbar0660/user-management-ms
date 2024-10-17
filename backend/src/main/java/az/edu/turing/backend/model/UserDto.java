package az.edu.turing.backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    @NotNull
    @NotBlank
    private String fullName;
    @NotNull
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;
}
