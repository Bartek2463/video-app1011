package pl.szybiak;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.szybiak.model.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VideoACassetteServiceTest {

    @Test
    public void findAll() {
        //given
        VideoACassetteService videoACassetteService = mock(VideoACassetteService.class);
        //when
        when(videoACassetteService.findAll()).thenReturn(prepreMockDate());
        //then
        Assert.assertThat(videoACassetteService.findAll(), Matchers.hasSize(2));
    }

    private List<VideoCassette> prepreMockDate() {
        List<VideoCassette> videoCassettes = new ArrayList<>();

        videoCassettes.add(new VideoCassette(1L, "Impossible", LocalDate.of(1993, 1, 2)));
        videoCassettes.add(new VideoCassette(2L, "Rambo", LocalDate.of(1998, 3, 4)));
        return videoCassettes;
    }
}