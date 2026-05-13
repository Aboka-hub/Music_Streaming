package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanPlaylistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanPlaylistResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanPlaylistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/playlists")
@RequiredArgsConstructor
public class NurtayAbylaikhanPlaylistController {

    private final NurtayAbylaikhanPlaylistService playlistService;

    @PostMapping
    public ResponseEntity<NurtayAbylaikhanPlaylistResponse> create(
            @Valid @RequestBody NurtayAbylaikhanPlaylistRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanPlaylistResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanPlaylistResponse>> getAll() {
        return ResponseEntity.ok(playlistService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanPlaylistResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody NurtayAbylaikhanPlaylistRequest request) {
        return ResponseEntity.ok(playlistService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playlistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<NurtayAbylaikhanPlaylistResponse> addTrack(
            @PathVariable Long playlistId,
            @PathVariable Long trackId) {
        return ResponseEntity.ok(playlistService.addTrack(playlistId, trackId));
    }

    @DeleteMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<NurtayAbylaikhanPlaylistResponse> removeTrack(
            @PathVariable Long playlistId,
            @PathVariable Long trackId) {
        return ResponseEntity.ok(playlistService.removeTrack(playlistId, trackId));
    }
}
