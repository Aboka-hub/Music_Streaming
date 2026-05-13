package cb.empty.music_streaming.mapper;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanUserRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanUserResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import org.springframework.stereotype.Component;

@Component
public class NurtayAbylaikhanUserMapper {

    public NurtayAbylaikhanUserResponse toResponse(NurtayAbylaikhanUser user) {
        NurtayAbylaikhanUserResponse response = new NurtayAbylaikhanUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }

    public NurtayAbylaikhanUser toEntity(NurtayAbylaikhanUserRequest request) {
        NurtayAbylaikhanUser user = new NurtayAbylaikhanUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        return user;
    }
}
