package cb.empty.music_streaming.repository;

import cb.empty.music_streaming.entity.NurtayAbylaikhanGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NurtayAbylaikhanGenreRepository extends JpaRepository<NurtayAbylaikhanGenre, Long> {

    Optional<NurtayAbylaikhanGenre> findByName(String Name);
}
