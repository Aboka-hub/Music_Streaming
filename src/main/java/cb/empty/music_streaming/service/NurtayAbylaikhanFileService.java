package cb.empty.music_streaming.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface NurtayAbylaikhanFileService {
    String uploadFile(MultipartFile file, Long trackId);
    Resource downloadFile(Long trackId);
}
