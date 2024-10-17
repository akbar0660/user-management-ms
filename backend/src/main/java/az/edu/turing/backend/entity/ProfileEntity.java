package az.edu.turing.backend.entity;

import az.edu.turing.backend.model.enums.MediaType;
import az.edu.turing.backend.model.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profiles")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    private byte[] profileImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
