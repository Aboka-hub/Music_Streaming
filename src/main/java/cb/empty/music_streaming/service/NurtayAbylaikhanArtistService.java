package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanArtistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanArtistResponse;

import java.util.List;

public interface NurtayAbylaikhanArtistService {
    NurtayAbylaikhanArtistResponse create(NurtayAbylaikhanArtistRequest request);

    NurtayAbylaikhanArtistResponse getById(Long id);

    List<NurtayAbylaikhanArtistResponse> getAll();

    NurtayAbylaikhanArtistResponse update(Long id, NurtayAbylaikhanArtistRequest request);

    void delete(Long id);
}
