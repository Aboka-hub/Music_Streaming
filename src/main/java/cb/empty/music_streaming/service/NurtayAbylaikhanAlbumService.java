package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanAlbumRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAlbumResponse;

import java.util.List;

public interface NurtayAbylaikhanAlbumService {
    NurtayAbylaikhanAlbumResponse create(NurtayAbylaikhanAlbumRequest request);
    NurtayAbylaikhanAlbumResponse getById(Long id);
    List<NurtayAbylaikhanAlbumResponse> getAll();
    NurtayAbylaikhanAlbumResponse update(Long id, NurtayAbylaikhanAlbumRequest request);
    void delete(Long id);
}
