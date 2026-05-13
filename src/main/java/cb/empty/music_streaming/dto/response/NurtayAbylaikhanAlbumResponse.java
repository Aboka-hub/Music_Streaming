package cb.empty.music_streaming.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanAlbumResponse {

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String artistName;
    private String genreName;

}
