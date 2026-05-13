package cb.empty.music_streaming.dto.request;

import cb.empty.music_streaming.enums.NurtayAbylaikhanRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurtayAbylaikhanUserRequest {

    @NotBlank
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;

    private NurtayAbylaikhanRole role;
}
