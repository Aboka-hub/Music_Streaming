package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanTrackRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanTrackResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NurtayAbylaikhanTrackService {
    NurtayAbylaikhanTrackResponse create(NurtayAbylaikhanTrackRequest request);

    NurtayAbylaikhanTrackResponse getById(Long id);

    List<NurtayAbylaikhanTrackResponse> getAll();

    NurtayAbylaikhanTrackResponse update(Long id, NurtayAbylaikhanTrackRequest request);

    Page<NurtayAbylaikhanTrackResponse> search(String title, Long albumId, Pageable pageable);

    void delete(Long id);
}
