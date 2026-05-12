package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NurtayAbylaikhanTrackRepository extends JpaRepository<NurtayAbylaikhanTrack, Long> {
    Optional<NurtayAbylaikhanTrack> findByAlbumId(Long id);
}
