package cb.empty.music_streaming.service.impl;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanLoginRequest;
import cb.empty.music_streaming.dto.request.NurtayAbylaikhanRegisterRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAuthResponse;
import cb.empty.music_streaming.entity.NurtayAbylaikhanUser;
import cb.empty.music_streaming.enums.NurtayAbylaikhanRole;
import cb.empty.music_streaming.repository.NurtayAbylaikhanUserRepository;
import cb.empty.music_streaming.security.jwt.NurtayAbylaikhanJwtUtil;
import cb.empty.music_streaming.service.NurtayAbylaikhanAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NurtayAbylaikhanAuthServiceImpl implements NurtayAbylaikhanAuthService {

    private final NurtayAbylaikhanUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final NurtayAbylaikhanJwtUtil jwtUtil;

    @Override
    public NurtayAbylaikhanAuthResponse register(NurtayAbylaikhanRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        NurtayAbylaikhanUser user = new NurtayAbylaikhanUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : NurtayAbylaikhanRole.USER);
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUsername());
        return new NurtayAbylaikhanAuthResponse(token, user.getUsername(), user.getRole().name());
    }

    @Override
    public NurtayAbylaikhanAuthResponse login(NurtayAbylaikhanLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));
        NurtayAbylaikhanUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtUtil.generateToken(user.getUsername());
        return new NurtayAbylaikhanAuthResponse(token, user.getUsername(), user.getRole().name());
    }
}