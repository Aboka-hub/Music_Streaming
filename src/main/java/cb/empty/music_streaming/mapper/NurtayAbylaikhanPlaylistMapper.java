package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanPlaylistRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanPlaylistResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanPlaylist;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanPlaylistMapper {

    public NurtayAbylaikhanPlaylistResponse toResponse(NurtayAbylaikhanPlaylist playlist){
        NurtayAbylaikhanPlaylistResponse response = new NurtayAbylaikhanPlaylistResponse();
        response.setId(playlist.getId());
        response.setName(playlist.getName());
        response.setUsername(playlist.getUser().getUsername());
        response.setCreatedAt(playlist.getCreatedDate());
        return response;
    }

    public NurtayAbylaikhanPlaylist toEntity(NurtayAbylaikhanPlaylistRequest request){
        NurtayAbylaikhanPlaylist playlist = new NurtayAbylaikhanPlaylist();
        playlist.setName(request.getName());
        return playlist;
    }
}
