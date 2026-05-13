package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanTrackRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanTrackResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanAlbum;
import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanTrackMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanAlbumRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanTrackRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanTrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanTrackServiceImpl implements NurtayAbylaikhanTrackService {

    private final NurtayAbylaikhanTrackRepository trackRepository;
    private final NurtayAbylaikhanTrackMapper trackMapper;
    private final NurtayAbylaikhanAlbumRepository albumRepository;

    @Override
    public NurtayAbylaikhanTrackResponse create(NurtayAbylaikhanTrackRequest request) {
        NurtayAbylaikhanAlbum album = albumRepository.findById(request.getAlbumId())
                .orElseThrow(() -> new RuntimeException("Album not found"));
        NurtayAbylaikhanTrack track = trackMapper.toEntity(request);
        track.setAlbum(album);
        return trackMapper.toResponse(trackRepository.save(track));
    }

    @Override
    public NurtayAbylaikhanTrackResponse getById(Long id) {
        NurtayAbylaikhanTrack track = trackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Track not found"));
        return trackMapper.toResponse(track);
    }

    @Override
    public List<NurtayAbylaikhanTrackResponse> getAll() {
        return trackRepository.findAll()
                .stream()
                .map(trackMapper::toResponse)
                .toList();
    }

    @Override
    public NurtayAbylaikhanTrackResponse update(Long id, NurtayAbylaikhanTrackRequest request) {
        NurtayAbylaikhanTrack track = trackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Track not found"));
        track.setTitle(request.getTitle());
        track.setDuration(request.getDuration());
        return trackMapper.toResponse(trackRepository.save(track));
    }

    @Override
    public void delete(Long id) {
        trackRepository.deleteById(id);
    }
}