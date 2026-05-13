package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanPlaylistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanPlaylistResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanPlaylist;
import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import cb.empty.music_streaming.exception.NurtayAbylaikhanNotFoundException;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanPlaylistMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanPlaylistRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanTrackRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanUserRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanAsyncService;
import cb.empty.music_streaming.service.NurtayAbylaikhanPlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanPlaylistServiceImpl implements NurtayAbylaikhanPlaylistService {

    private final NurtayAbylaikhanPlaylistRepository playlistRepository;
    private final NurtayAbylaikhanPlaylistMapper playlistMapper;
    private final NurtayAbylaikhanUserRepository userRepository;
    private final NurtayAbylaikhanTrackRepository trackRepository;
    private final NurtayAbylaikhanAsyncService asyncService;

    @Override
    public NurtayAbylaikhanPlaylistResponse create(NurtayAbylaikhanPlaylistRequest request) {
        NurtayAbylaikhanUser user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("User not found"));
        NurtayAbylaikhanPlaylist playlist = playlistMapper.toEntity(request);
        playlist.setUser(user);
        NurtayAbylaikhanPlaylist saved = playlistRepository.save(playlist);
        asyncService.logPlaylistCreated(saved.getName(), user.getUsername());
        return playlistMapper.toResponse(saved);
    }

    @Override
    public NurtayAbylaikhanPlaylistResponse getById(Long id) {
        NurtayAbylaikhanPlaylist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Playlist not found"));
        return playlistMapper.toResponse(playlist);
    }

    @Override
    public List<NurtayAbylaikhanPlaylistResponse> getAll() {
        return playlistRepository.findAll()
                .stream()
                .map(playlistMapper::toResponse)
                .toList();
    }

    @Override
    public NurtayAbylaikhanPlaylistResponse update(Long id, NurtayAbylaikhanPlaylistRequest request) {
        NurtayAbylaikhanPlaylist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Playlist not found"));
        playlist.setName(request.getName());
        return playlistMapper.toResponse(playlistRepository.save(playlist));
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public NurtayAbylaikhanPlaylistResponse addTrack(Long playlistId, Long trackId) {
        NurtayAbylaikhanPlaylist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Playlist not found"));
        NurtayAbylaikhanTrack track = trackRepository.findById(trackId)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Track not found"));
        playlist.getTracks().add(track);
        return playlistMapper.toResponse(playlistRepository.save(playlist));
    }

    @Override
    public NurtayAbylaikhanPlaylistResponse removeTrack(Long playlistId, Long trackId) {
        NurtayAbylaikhanPlaylist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Playlist not found"));
        playlist.getTracks().removeIf(track -> track.getId().equals(trackId));
        return playlistMapper.toResponse(playlistRepository.save(playlist));
    }
}