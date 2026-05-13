package cb.empty.music_streaming.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanArtistRequest {

    @NotBlank
    private String stageName;
    @NotBlank
    private String bio;
    @NotNull
    private Long userId;
}
