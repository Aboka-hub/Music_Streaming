package cb.empty.music_streaming.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanPlaylistRequest {
    @NotBlank
    private String name;
    @NotNull
    private Long userId;
}
