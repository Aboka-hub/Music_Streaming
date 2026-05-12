package cb.empty.music_streaming.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "album")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(unique = true, nullable = false)
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private NurtayAbylaikhanArtist artist;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<NurtayAbylaikhanTrack> tracks;

    @ManyToOne(fetch = FetchType.LAZY)
    private NurtayAbylaikhanGenre genre;
}
