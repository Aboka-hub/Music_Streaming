package cb.empty.music_streaming.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "artist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String stageName;

    @Column(nullable = false)
    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private NurtayAbylaikhanUser user;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<NurtayAbylaikhanAlbum> albums;
}
