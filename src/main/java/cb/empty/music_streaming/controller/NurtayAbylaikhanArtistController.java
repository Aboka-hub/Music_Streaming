package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanArtistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanArtistResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
public class NurtayAbylaikhanArtistController {

    private final NurtayAbylaikhanArtistService artistService;

    @PostMapping
    public ResponseEntity<NurtayAbylaikhanArtistResponse> create(
            @Valid @RequestBody NurtayAbylaikhanArtistRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanArtistResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanArtistResponse>> getAll() {
        return ResponseEntity.ok(artistService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanArtistResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody NurtayAbylaikhanArtistRequest request) {
        return ResponseEntity.ok(artistService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}