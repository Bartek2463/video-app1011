package pl.szybiak.service;

import org.assertj.core.api.Assertions;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class VideoACassetteServiceTest {

    private static final VideoCassette VIDEO_CASETTE = new VideoCassette(3l, "Rambo", LocalDate.of(1993, 3, 4));
    private static final VideoCassette VIDEO_CASETTE2 = new VideoCassette(2l, "Rambo", LocalDate.of(1993, 3, 4));

    @Mock
    private VideoAssettsRepository videoAssettsRepository;

    @InjectMocks
    private VideoACassetteService videoACassetteService;


    @Test
    @DisplayName("Should get Id for One Videocassetts ")
    void shouldGetIdForOneVideocassets() {
        Mockito.when(videoAssettsRepository.findById(VIDEO_CASETTE.getId())).thenReturn(Optional.of(VIDEO_CASETTE));
        VideoCassette result = videoACassetteService.findById(3l);

        assertEquals(result,VIDEO_CASETTE);//junit

        Assertions.assertThat(result).isEqualTo(VIDEO_CASETTE); //assertJ
        Assertions.assertThat(result).isNotNull();
    }
    @Test
    @DisplayName("Should get List Videocassets ")
    void shouldGetListVideocassets() {
        Mockito.when(videoAssettsRepository.findAll()).thenReturn(videoCassetteList());
        Assertions.assertThat(videoACassetteService.findAll()).hasSize(2);
    }

    @Test
    @DisplayName("Should add Videocassette")
    void should_Add_VideoCassette() {
        Mockito.when(videoAssettsRepository.save(any(VideoCassette.class))).thenReturn(VIDEO_CASETTE);
        VideoCassette save = videoACassetteService.save(new VideoCassette());
        assertEquals(save.getId(), 3l);
        assertEquals(save.getTitle(), "Rambo");
        assertEquals(save.getProductionYear(), LocalDate.of(1993, 3, 4));
        Assertions.assertThat(save).isEqualTo(VIDEO_CASETTE);
    }

    @Test
    void deleteById() {

    }

    @Test
    void fillDB() {
    }

    private List<VideoCassette> videoCassetteList() {
        List<VideoCassette> videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(3l, "Rambo", LocalDate.of(1993, 3, 4)));
        videoCassettes.add(new VideoCassette(2l, "Szambo", LocalDate.of(1993, 3, 4)));
        return videoCassettes;
    }
}