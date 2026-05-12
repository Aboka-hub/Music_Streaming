package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanArtist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NurtayAbylaikhanArtistRepository extends JpaRepository<NurtayAbylaikhanArtist, Long> {
    Optional<NurtayAbylaikhanArtist> findByStageName(String stageName);
}
