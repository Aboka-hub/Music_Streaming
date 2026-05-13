package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanGenreRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanGenreResponse;

import java.util.List;

public interface NurtayAbylaikhanGenreService {
    NurtayAbylaikhanGenreResponse create(NurtayAbylaikhanGenreRequest request);
    NurtayAbylaikhanGenreResponse getById(Long id);
    List<NurtayAbylaikhanGenreResponse> getAll();
    NurtayAbylaikhanGenreResponse update(Long id, NurtayAbylaikhanGenreRequest request);
    void delete(Long id);
}