package cb.empty.music_streaming.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanTrackResponse {

    private Long id;
    private String title;
    private Integer duration;
    private String albumTitle;
    private String filePath;
    private LocalDateTime createdAt;
}
