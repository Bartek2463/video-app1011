package pl.szybiak.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.szybiak.model.VideoCassette;
import pl.szybiak.repository.VideoAssettsRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class VideoACassetteServiceTest {

    private final VideoCassette VIDEO_CASETTE = new VideoCassette(1l,"Rambo", LocalDate.of(1993,4,5));

    @Mock
    private VideoAssettsRepository videoAssettsRepository;

    @InjectMocks
    private VideoACassetteService videoACassetteService;


    @Test
    @DisplayName("Should find Class Videocassets Byid")
    void findById() {
        Mockito.when(videoAssettsRepository.findById(anyLong())).thenReturn(Optional.of(VIDEO_CASETTE));

        VideoCassette result = videoACassetteService.findById(2l);


        assertEquals(result,VIDEO_CASETTE);
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void fillDB() {
    }
}