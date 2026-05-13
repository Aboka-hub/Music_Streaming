package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import cb.empty.music_streaming.exception.NurtayAbylaikhanNotFoundException;
import cb.empty.music_streaming.repository.NurtayAbylaikhanTrackRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanFileServiceImpl implements NurtayAbylaikhanFileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final NurtayAbylaikhanTrackRepository trackRepository;

    @Override
    public String uploadFile(MultipartFile file, Long trackId) {
        try {
            NurtayAbylaikhanTrack track = trackRepository.findById(trackId)
                    .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Track not found"));

            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = trackId + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            track.setFilePath(filePath.toString());
            trackRepository.save(track);

            return "File uploaded: " + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    @Override
    public Resource downloadFile(Long trackId) {
        try {
            NurtayAbylaikhanTrack track = trackRepository.findById(trackId)
                    .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Track not found"));

            Path filePath = Paths.get(track.getFilePath());
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                throw new NurtayAbylaikhanNotFoundException("File not found");
            }
            return resource;
        } catch (IOException e) {
            throw new RuntimeException("Failed to download file: " + e.getMessage());
        }
    }
}
