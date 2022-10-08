package pl.szybiak.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.repository.VideoAssettsRepository;

import java.time.DateTimeException;
import java.util.List;

@Service
@AllArgsConstructor

public class VideoACassetteService {
    @Autowired
    private VideoAssettsRepository videoAssettsRepository;


    public VideoCassette findById(Long id) {
        return videoAssettsRepository.findById(id).orElse(null);
    }

    public List<VideoCassette> findAll() {
        return (List<VideoCassette>) videoAssettsRepository.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        if (videoCassette.getTitle().isBlank() || videoCassette.getTitle() == null) {
            throw new IllegalArgumentException("Title can not by Blank");
        } else if (videoCassette.getProductionYear() == null) {
            throw new IllegalArgumentException("Data production Year can not by null and should by format Data YYYY-MM-dd ");
        }
        return videoAssettsRepository.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoAssettsRepository.deleteById(id);
    }

}