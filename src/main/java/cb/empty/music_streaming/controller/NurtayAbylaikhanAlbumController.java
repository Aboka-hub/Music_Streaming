package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanAlbumRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAlbumResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanAlbumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class NurtayAbylaikhanAlbumController {

    private final NurtayAbylaikhanAlbumService albumService;

    @PostMapping
    public ResponseEntity<NurtayAbylaikhanAlbumResponse> create(
            @Valid @RequestBody NurtayAbylaikhanAlbumRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanAlbumResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanAlbumResponse>> getAll() {
        return ResponseEntity.ok(albumService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanAlbumResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody NurtayAbylaikhanAlbumRequest request) {
        return ResponseEntity.ok(albumService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}