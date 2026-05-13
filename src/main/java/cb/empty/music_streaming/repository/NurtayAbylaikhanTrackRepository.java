package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurtayAbylaikhanTrackRepository extends JpaRepository<NurtayAbylaikhanTrack, Long> {

    Page<NurtayAbylaikhanTrack> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<NurtayAbylaikhanTrack> findByAlbumId(Long albumId, Pageable pageable);
}
