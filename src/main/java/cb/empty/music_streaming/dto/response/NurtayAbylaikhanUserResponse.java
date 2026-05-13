package cb.empty.music_streaming.dto.response;

import cb.empty.music_streaming.enums.NurtayAbylaikhanRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanUserResponse {

    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private NurtayAbylaikhanRole role;
}
