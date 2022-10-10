package pl.szybiak.service;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.repository.VideoAssettsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class VideoACassetteServiceTest {

    private static final VideoCassette VIDEO_CASETTE = new VideoCassette(3l,"Rambo", LocalDate.of(1993,3,4));

    @Mock
    private VideoAssettsRepository videoAssettsRepository;

    @InjectMocks
    private VideoACassetteService videoACassetteService;




    @Test
    void findById() {
        Mockito.when(videoAssettsRepository.findById(VIDEO_CASETTE.getId())).thenReturn(Optional.of(VIDEO_CASETTE));
        VideoCassette result = videoACassetteService.findById(1l);
        Assertions.assertThat(result).isEqualTo(VIDEO_CASETTE);
        System.out.println();

    }

    @Test
    void findAll() {
        Mockito.when(videoACassetteService.findAll()).thenReturn(videoCassetteList());

        Assertions.assertThat(videoACassetteService.findAll()).hasSize(2);
    }

    @Test
    void save() {
        Mockito.when(videoACassetteService.save(any(VideoCassette.class))).thenReturn(VIDEO_CASETTE);
        VideoCassette save = videoACassetteService.save(new VideoCassette());
        assertEquals(save.getId(),3l);
        assertEquals(save.getTitle(),"Rambo");
        assertEquals(save.getProductionYear(),LocalDate.of(1993,3,4));

    }

    @Test
    void deleteById() {

    }

    @Test
    void fillDB() {
    }

    private List<VideoCassette> videoCassetteList(){
        List<VideoCassette> videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(3l,"Rambo", LocalDate.of(1993,3,4)));
        videoCassettes.add(new VideoCassette(2l,"Szambo", LocalDate.of(1993,3,4)));
        return videoCassettes;
    }
}