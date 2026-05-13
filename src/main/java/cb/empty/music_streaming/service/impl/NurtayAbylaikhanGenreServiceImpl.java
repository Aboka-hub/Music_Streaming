package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanGenreRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanGenreResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanGenre;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanGenreMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanGenreRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanGenreServiceImpl implements NurtayAbylaikhanGenreService {

    private final NurtayAbylaikhanGenreRepository genreRepository;
    private final NurtayAbylaikhanGenreMapper genreMapper;

    @Override
    public NurtayAbylaikhanGenreResponse create(NurtayAbylaikhanGenreRequest request) {
        NurtayAbylaikhanGenre genre = genreMapper.toEntity(request);
        return genreMapper.toResponse(genreRepository.save(genre));
    }

    @Override
    public NurtayAbylaikhanGenreResponse getById(Long id) {
        NurtayAbylaikhanGenre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return genreMapper.toResponse(genre);
    }

    @Override
    public List<NurtayAbylaikhanGenreResponse> getAll() {
        return genreRepository.findAll()
                .stream()
                .map(genreMapper::toResponse)
                .toList();
    }

    @Override
    public NurtayAbylaikhanGenreResponse update(Long id, NurtayAbylaikhanGenreRequest request) {
        NurtayAbylaikhanGenre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(request.getName());
        return genreMapper.toResponse(genreRepository.save(genre));
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
