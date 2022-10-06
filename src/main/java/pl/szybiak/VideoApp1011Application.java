package pl.szybiak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.repository.VideoAssettsRepository;

import java.time.LocalDate;

@SpringBootApplication
public class VideoApp1011Application {

    public static void main(String[] args) {
        SpringApplication.run(VideoApp1011Application.class, args);
    }
    @Autowired
    private VideoAssettsRepository videoAssettsRepository;
    @EventListener(ApplicationReadyEvent.class)
    public  void init(){
        videoAssettsRepository.save(new VideoCassette(1L, "Impossible", LocalDate.of(1993, 1, 2)));
        videoAssettsRepository.save(new VideoCassette(2L, "Rambo", LocalDate.of(1998, 3, 4)));
    }

}
