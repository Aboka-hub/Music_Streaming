package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanUserRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NurtayAbylaikhanUserService {
    NurtayAbylaikhanUserResponse getById(Long id);
    List<NurtayAbylaikhanUserResponse> getAll();
    NurtayAbylaikhanUserResponse update(Long id, NurtayAbylaikhanUserRequest request);
    Page<NurtayAbylaikhanUserResponse> getByUsernameContainingIgnoreCase(String username, Pageable pageable);
    void delete(Long id);
}