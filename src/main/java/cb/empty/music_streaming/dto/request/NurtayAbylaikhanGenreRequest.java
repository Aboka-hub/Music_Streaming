package cb.empty.music_streaming.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanGenreRequest {
    @NotBlank
    private String name;
}
