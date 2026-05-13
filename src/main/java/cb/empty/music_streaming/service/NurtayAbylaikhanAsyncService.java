package cb.empty.music_streaming.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class NurtayAbylaikhanAsyncService {

    // Async 1 — лог когда загружается файл
    @Async
    public CompletableFuture<String> logFileUpload(String fileName, Long trackId) {
        log.info("File upload started: {} for track id: {}", fileName, trackId);
        return CompletableFuture.completedFuture(
                "File " + fileName + " uploaded for track " + trackId);
    }

    // Async 2 — лог когда регистрируется новый пользователь
    @Async
    public CompletableFuture<String> sendWelcomeNotification(String username) {
        log.info("Welcome notification sent to: {}", username);
        return CompletableFuture.completedFuture(
                "Welcome notification sent to " + username);
    }

    // Async 3 — лог когда создаётся плейлист
    @Async
    public CompletableFuture<String> logPlaylistCreated(String playlistName, String username) {
        log.info("Playlist '{}' created by user: {}", playlistName, username);
        return CompletableFuture.completedFuture(
                "Playlist " + playlistName + " created by " + username);
    }
}