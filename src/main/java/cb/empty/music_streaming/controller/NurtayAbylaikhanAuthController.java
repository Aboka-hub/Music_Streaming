package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanLoginRequest;
import cb.empty.music_streaming.dto.request.NurtayAbylaikhanRegisterRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAuthResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class NurtayAbylaikhanAuthController {

    private final NurtayAbylaikhanAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<NurtayAbylaikhanAuthResponse> register(
            @Valid @RequestBody NurtayAbylaikhanRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<NurtayAbylaikhanAuthResponse> login(
            @Valid @RequestBody NurtayAbylaikhanLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
