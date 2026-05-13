package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanUserRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanUserResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import cb.empty.music_streaming.exception.NurtayAbylaikhanNotFoundException;
import cb.empty.music_streaming.mapper.NurtayAbylaikhanUserMapper;
import cb.empty.music_streaming.repository.NurtayAbylaikhanUserRepository;
import cb.empty.music_streaming.service.NurtayAbylaikhanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanUserServiceImpl implements NurtayAbylaikhanUserService {

    private final NurtayAbylaikhanUserRepository userRepository;
    private final NurtayAbylaikhanUserMapper userMapper;

    @Override
    public NurtayAbylaikhanUserResponse getById(Long id) {
        NurtayAbylaikhanUser user = userRepository.findById(id)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("User not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public List<NurtayAbylaikhanUserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public NurtayAbylaikhanUserResponse update(Long id, NurtayAbylaikhanUserRequest request) {
        NurtayAbylaikhanUser user = userRepository.findById(id)
                .orElseThrow(() -> new NurtayAbylaikhanNotFoundException("User not found"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}