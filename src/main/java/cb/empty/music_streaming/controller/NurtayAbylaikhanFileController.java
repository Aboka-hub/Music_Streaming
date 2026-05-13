package cb.empty.music_streaming.controller;

import cb.empty.music_streaming.service.NurtayAbylaikhanFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/tracks")
@RequiredArgsConstructor
public class NurtayAbylaikhanFileController {

    private final NurtayAbylaikhanFileService fileService;

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> upload(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileService.uploadFile(file, id));
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> download(@PathVariable Long id) {
        Resource resource = fileService.downloadFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
