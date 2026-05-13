package cb.empty.music_streaming.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanPlaylistResponse {

    private Long id;
    private String name;
    private String username;
    private LocalDateTime createdAt;
}
