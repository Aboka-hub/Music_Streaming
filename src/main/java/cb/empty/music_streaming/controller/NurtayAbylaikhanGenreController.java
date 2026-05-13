package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanGenreRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanGenreResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanGenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class NurtayAbylaikhanGenreController {

    private final NurtayAbylaikhanGenreService genreService;

    @PostMapping
    public ResponseEntity<NurtayAbylaikhanGenreResponse> create(
            @Valid @RequestBody NurtayAbylaikhanGenreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanGenreResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanGenreResponse>> getAll() {
        return ResponseEntity.ok(genreService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanGenreResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody NurtayAbylaikhanGenreRequest request) {
        return ResponseEntity.ok(genreService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}