package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanAlbumRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAlbumResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanAlbum;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanAlbumMapper {

    public NurtayAbylaikhanAlbumResponse toResponse(NurtayAbylaikhanAlbum album) {
        NurtayAbylaikhanAlbumResponse response = new NurtayAbylaikhanAlbumResponse();
        response.setId(album.getId());
        response.setTitle(album.getTitle());
        response.setReleaseDate(album.getReleaseDate());
        response.setArtistName(album.getArtist().getStageName());
        response.setGenreName(album.getGenre().getName());
        return response;
    }

    public NurtayAbylaikhanAlbum toEntity(NurtayAbylaikhanAlbumRequest request) {
        NurtayAbylaikhanAlbum album = new NurtayAbylaikhanAlbum();
        album.setTitle(request.getTitle());
        album.setReleaseDate(request.getReleaseDate());
        return album;
    }

}
