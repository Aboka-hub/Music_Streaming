package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurtayAbylaikhanUserRepository extends JpaRepository<NurtayAbylaikhanUser, Long> {
    Optional<NurtayAbylaikhanUser> findByEmail(String email);
    Optional<NurtayAbylaikhanUser> findByUsername(String username);
    Page<NurtayAbylaikhanUser> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
    boolean existsByEmail(String email);
}