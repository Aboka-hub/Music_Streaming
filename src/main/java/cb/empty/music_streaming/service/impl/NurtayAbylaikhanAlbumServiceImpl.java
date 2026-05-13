package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanAlbumRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAlbumResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanAlbum;
import cb.empty.music_streaming.entity.NurtayAbylaikhanArtist;
import cb.empty.music_streaming.entity.NurtayAbylaikhanGenre;
import cb.empty.music_streaming.exception.NurtayAbylaikhanNotFoundException;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanAlbumMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanAlbumRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanArtistRepository;
import cb.empty.music_streaming.repository.NurtayAbylaikhanGenreRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanAlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanAlbumServiceImpl implements NurtayAbylaikhanAlbumService {

    private final NurtayAbylaikhanAlbumRepository albumRepository;
    private final NurtayAbylaikhanAlbumMapper albumMapper;
    private final NurtayAbylaikhanArtistRepository artistRepository;
    private final NurtayAbylaikhanGenreRepository genreRepository;

    @Override
    public NurtayAbylaikhanAlbumResponse create(NurtayAbylaikhanAlbumRequest request) {
        NurtayAbylaikhanArtist artist = artistRepository.findById(request.getArtistId()).orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Artist not found"));
        NurtayAbylaikhanGenre genre = genreRepository.findById(request.getGenreId()).orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Genre not found"));
        NurtayAbylaikhanAlbum album = albumMapper.toEntity(request);
        album.setArtist(artist);
        album.setGenre(genre);
        return albumMapper.toResponse(albumRepository.save(album));
    }

    @Override
    public NurtayAbylaikhanAlbumResponse getById(Long id) {
        NurtayAbylaikhanAlbum album = albumRepository.findById(id).orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Album not found"));
        return albumMapper.toResponse(album);
    }

    @Override
    public List<NurtayAbylaikhanAlbumResponse> getAll() {
        return albumRepository.findAll().stream().map(albumMapper::toResponse).toList();
    }

    @Override
    public NurtayAbylaikhanAlbumResponse update(Long id, NurtayAbylaikhanAlbumRequest request) {
        NurtayAbylaikhanAlbum album = albumRepository.findById(id).orElseThrow(() -> new NurtayAbylaikhanNotFoundException("Album not found"));
        album.setTitle(request.getTitle());
        album.setReleaseDate(request.getReleaseDate());
        return albumMapper.toResponse(albumRepository.save(album));
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}