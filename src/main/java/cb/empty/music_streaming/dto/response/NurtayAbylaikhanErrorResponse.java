package cb.empty.music_streaming.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}