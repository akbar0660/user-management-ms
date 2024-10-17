package az.edu.turing.bffweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private String fullName;
    private int age;
}
