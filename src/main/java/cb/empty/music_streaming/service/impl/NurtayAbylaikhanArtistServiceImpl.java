package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanArtistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanArtistResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanArtist;
import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanArtistMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanArtistRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanUserRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanArtistServiceImpl implements NurtayAbylaikhanArtistService {

    private final NurtayAbylaikhanArtistRepository artistRepository;
    private final NurtayAbylaikhanArtistMapper artistMapper;
    private final NurtayAbylaikhanUserRepository userRepository;

    @Override
    public NurtayAbylaikhanArtistResponse create(NurtayAbylaikhanArtistRequest request) {
        NurtayAbylaikhanUser user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        NurtayAbylaikhanArtist artist = artistMapper.toEntity(request);
        artist.setUser(user);
        return artistMapper.toResponse(artistRepository.save(artist));
    }

    @Override
    public NurtayAbylaikhanArtistResponse getById(Long id) {
        NurtayAbylaikhanArtist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        return artistMapper.toResponse(artist);
    }

    @Override
    public List<NurtayAbylaikhanArtistResponse> getAll() {
        return artistRepository.findAll()
                .stream()
                .map(artistMapper::toResponse)
                .toList();
    }

    @Override
    public NurtayAbylaikhanArtistResponse update(Long id, NurtayAbylaikhanArtistRequest request) {
        NurtayAbylaikhanArtist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        artist.setStageName(request.getStageName());
        artist.setBio(request.getBio());
        return artistMapper.toResponse(artistRepository.save(artist));
    }

    @Override
    public void delete(Long id) {
        artistRepository.deleteById(id);
    }
}
