package cb.empty.music_streaming.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurtayAbylaikhanTrackRequest {
    @NotBlank
    private String title;
    @NotNull
    private Integer duration;
    @NotNull
    private Long albumId;
}
