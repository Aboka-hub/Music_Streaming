package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanGenreRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanGenreResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanGenre;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanGenreMapper {

    public NurtayAbylaikhanGenreResponse toResponse(NurtayAbylaikhanGenre genre) {
        NurtayAbylaikhanGenreResponse response = new NurtayAbylaikhanGenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
    public NurtayAbylaikhanGenre toEntity(NurtayAbylaikhanGenreRequest request) {
        NurtayAbylaikhanGenre genre = new NurtayAbylaikhanGenre();
        genre.setName(request.getName());
        return genre;
    }
}
