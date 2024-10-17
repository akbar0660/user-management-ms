package az.edu.turing.backend.repository;

import az.edu.turing.backend.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    List<ProfileEntity> findByUserId(Long userId);

    Optional<ProfileEntity> findByIdAndUserId(Long profileId, Long userId);

    void deleteByIdAndUserId(Long profileId, Long userId);


}
