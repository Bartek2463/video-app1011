package pl.szybiak.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.repository.VideoAssettsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoACassetteService {

    private VideoAssettsRepository videoAssettsRepository;


    public VideoCassette findById(Long id){
        return videoAssettsRepository.findById(id).orElse(null);
    }
    public List<VideoCassette> findAll(){
        return videoAssettsRepository.findAll();
    }
    public VideoCassette save(VideoCassette videoCassette){
        return videoAssettsRepository.save(videoCassette);
    }
    public void deleteById(Long id){
        videoAssettsRepository.deleteById(id);
    }

}