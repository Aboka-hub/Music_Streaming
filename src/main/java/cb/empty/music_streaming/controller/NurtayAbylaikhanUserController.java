package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanUserRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanUserResponse;
import cb.empty.music_streaming.service.NurtayAbylaikhanUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class NurtayAbylaikhanUserController {

    private final NurtayAbylaikhanUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanUserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NurtayAbylaikhanUserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurtayAbylaikhanUserResponse> update(@PathVariable Long id, @Valid @RequestBody NurtayAbylaikhanUserRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page/get")
    public ResponseEntity<Page<NurtayAbylaikhanUserResponse>> getByUsernameContainingIgnoreCase(@RequestParam(required = false) String username, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getByUsernameContainingIgnoreCase(username, pageable));
    }
}