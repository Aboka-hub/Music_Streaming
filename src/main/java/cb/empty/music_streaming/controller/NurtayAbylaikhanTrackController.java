package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanTrackRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanTrackResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanTrackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
@RequiredArgsConstructor
public class NurtayAbylaikhanTrackController {

    private final NurtayAbylaikhanTrackService trackService;

    @PostMapping
    public ResponseEntity<NurtayAbylaikhanTrackResponse> create(
            @Valid @RequestBody NurtayAbylaikhanTrackRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trackService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanTrackResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trackService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanTrackResponse>> getAll() {
        return ResponseEntity.ok(trackService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanTrackResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody NurtayAbylaikhanTrackRequest request) {
        return ResponseEntity.ok(trackService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trackService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
