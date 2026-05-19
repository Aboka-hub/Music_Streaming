package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanTrackRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanTrackResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanTrack;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanTrackMapper {

    public NurtayAbylaikhanTrackResponse toResponse(NurtayAbylaikhanTrack track) {
        NurtayAbylaikhanTrackResponse response = new NurtayAbylaikhanTrackResponse();
        response.setId(track.getId());
        response.setTitle(track.getTitle());
        response.setDuration(track.getDuration());
        response.setAlbumTitle(track.getAlbum().getTitle());
        response.setFilePath(track.getFilePath());
        response.setCreatedAt(track.getCreatedAt());
        return response;
    }

    public NurtayAbylaikhanTrack toEntity(NurtayAbylaikhanTrackRequest request) {
        NurtayAbylaikhanTrack track = new NurtayAbylaikhanTrack();
        track.setTitle(request.getTitle());
        track.setDuration(request.getDuration());
        return track;
    }
}
