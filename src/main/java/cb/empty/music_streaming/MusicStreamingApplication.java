package cb.empty.music_streaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MusicStreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicStreamingApplication.class, args);
    }

}
