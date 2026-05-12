package cb.empty.music_streaming.entity;

import cb.empty.music_streaming.enums.NurtayAbylaikhanRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private NurtayAbylaikhanRole role;

    @Column(unique = true, nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    private NurtayAbylaikhanArtist artist;

    @OneToMany(fetch = FetchType.LAZY)
    private List<NurtayAbylaikhanPlaylist> playlist;

}
