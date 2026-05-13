package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanTrackRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanTrackResponse;

import java.util.List;

public interface NurtayAbylaikhanTrackService {
    NurtayAbylaikhanTrackResponse create(NurtayAbylaikhanTrackRequest request);
    NurtayAbylaikhanTrackResponse getById(Long id);
    List<NurtayAbylaikhanTrackResponse> getAll();
    NurtayAbylaikhanTrackResponse update(Long id, NurtayAbylaikhanTrackRequest request);
    void delete(Long id);
}
