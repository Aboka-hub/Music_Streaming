package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanUserRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanUserResponse;

import java.util.List;

public interface NurtayAbylaikhanUserService {
    NurtayAbylaikhanUserResponse getById(Long id);
    List<NurtayAbylaikhanUserResponse> getAll();
    NurtayAbylaikhanUserResponse update(Long id, NurtayAbylaikhanUserRequest request);
    void delete(Long id);
}