package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanPlaylistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanPlaylistResponse;

import java.util.List;

public interface NurtayAbylaikhanPlaylistService {
    NurtayAbylaikhanPlaylistResponse create(NurtayAbylaikhanPlaylistRequest request);
    NurtayAbylaikhanPlaylistResponse getById(Long id);
    List<NurtayAbylaikhanPlaylistResponse> getAll();
    NurtayAbylaikhanPlaylistResponse update(Long id, NurtayAbylaikhanPlaylistRequest request);
    void delete(Long id);
    NurtayAbylaikhanPlaylistResponse addTrack(Long playlistId, Long trackId);
    NurtayAbylaikhanPlaylistResponse removeTrack(Long playlistId, Long trackId);
}
