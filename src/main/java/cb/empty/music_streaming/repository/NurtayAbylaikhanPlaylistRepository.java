package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NurtayAbylaikhanPlaylistRepository extends JpaRepository<NurtayAbylaikhanPlaylist, Long> {

    Optional<NurtayAbylaikhanPlaylist> findByUserId(Long id);

    Optional<NurtayAbylaikhanPlaylist> findByNameContaining(String name);
}
