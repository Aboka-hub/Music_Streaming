package cb.empty.music_streaming.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
