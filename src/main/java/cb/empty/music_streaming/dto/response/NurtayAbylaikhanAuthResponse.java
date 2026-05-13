package cb.empty.music_streaming.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanAuthResponse {
    private String token;
    private String username;
    private String role;
}
