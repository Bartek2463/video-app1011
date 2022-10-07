package pl.szybiak.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.service.VideoACassetteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cassetts")
public class VideoCassetteApi {
    @Autowired
    private VideoACassetteService videoCassettes;


    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public VideoCassette getByid(@RequestParam Long index) {
        return videoCassettes.findById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        videoCassettes.deleteById(index);
    }

}