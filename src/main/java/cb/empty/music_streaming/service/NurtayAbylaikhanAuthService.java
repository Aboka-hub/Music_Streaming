package cb.empty.music_streaming.service;

import cb.empty.music_streaming.dto.request.NurtayAbylaikhanLoginRequest;
import cb.empty.music_streaming.dto.request.NurtayAbylaikhanRegisterRequest;
import cb.empty.music_streaming.dto.response.NurtayAbylaikhanAuthResponse;

public interface NurtayAbylaikhanAuthService {
    NurtayAbylaikhanAuthResponse register(NurtayAbylaikhanRegisterRequest request);
    NurtayAbylaikhanAuthResponse login(NurtayAbylaikhanLoginRequest request);
}