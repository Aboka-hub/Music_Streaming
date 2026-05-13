package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanArtistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanArtistResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanArtist;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanArtistMapper {

    public NurtayAbylaikhanArtistResponse toResponse(NurtayAbylaikhanArtist artist) {
        NurtayAbylaikhanArtistResponse response = new NurtayAbylaikhanArtistResponse();
        response.setId(artist.getId());
        response.setStageName(artist.getStageName());
        response.setUsername(artist.getUser().getUsername());
        response.setBio(artist.getBio());
        return response;
    }

    public NurtayAbylaikhanArtist toEntity(NurtayAbylaikhanArtistRequest request) {
        NurtayAbylaikhanArtist artist = new NurtayAbylaikhanArtist();
        artist.setStageName(request.getStageName());
        artist.setBio(request.getBio());
        return artist;
    }
}
