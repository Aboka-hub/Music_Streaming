package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurtayAbylaikhanAlbumRepository extends JpaRepository<NurtayAbylaikhanAlbum,Long> {

    List<NurtayAbylaikhanAlbum> findByArtistId(Long id);
    List<NurtayAbylaikhanAlbum> findByGenreId(Long id);
}
