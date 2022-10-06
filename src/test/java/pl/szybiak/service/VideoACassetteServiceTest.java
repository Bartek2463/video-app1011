package pl.szybiak.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.szybiak.model.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VideoACassetteServiceTest {

    @Test
    public void getVideo_cassets_List() {
        //given
        VideoACassetteService videoACassetteService = mock(VideoACassetteService.class);
        when(videoACassetteService.findAll()).thenReturn(prepreMockDate());
        //when
        List<VideoCassette> videoCassettes = videoACassetteService.findAll();
        //then
        Assert.assertThat(videoCassettes, Matchers.hasSize(2));
    }

    //BDD
    @Test
    public void getVideo_cassets_withBDD() {
        //given
        VideoACassetteService videoACassetteService = mock(VideoACassetteService.class);
        given(videoACassetteService.findAll()).willReturn(prepreMockDate());
        //when
        List<VideoCassette> videoCassettes = videoACassetteService.findAll();
        //then
        Assert.assertThat(videoCassettes, Matchers.hasSize(2));
        Assert.assertThat(videoCassettes, Matchers.notNullValue());
    }

    private List<VideoCassette> prepreMockDate() {
        List<VideoCassette> videoCassettes = new ArrayList<>();

        videoCassettes.add(new VideoCassette(1L, "Impossible", LocalDate.of(1993, 1, 2)));
        videoCassettes.add(new VideoCassette(2L, "Rambo", LocalDate.of(1998, 3, 4)));
        return videoCassettes;
    }

    @Test
    public void save() {
        //given
        VideoACassetteService videoACassetteService = mock(VideoACassetteService.class);
        given(videoACassetteService.save(Mockito.any(VideoCassette.class))).willReturn(new VideoCassette(3L, "Rambo", LocalDate.of(1998, 3, 4)));
        //when
        VideoCassette videoCassette = videoACassetteService.save(new VideoCassette());
        Assert.assertEquals(videoCassette.getTitle(), "Rambo");
        Assert.assertEquals(videoCassette.getProductionYear(), LocalDate.of(1998, 3, 4));
        Assert.assertEquals(videoCassette.getId().longValue(), 3);
        assertThat(videoCassette.getId()).isNotNull();
        assertThat(videoCassette.getProductionYear()).isNotNull();
        assertThat(videoCassette.getTitle()).isNotNull();

    }

    @Test
    public void bad_data_not_save() {
        //given
        VideoACassetteService videoACassetteService = mock(VideoACassetteService.class);
        given(videoACassetteService.save(Mockito.any(VideoCassette.class))).willReturn(new VideoCassette(null, null, null));
        //when
        VideoCassette videoCassette = videoACassetteService.save(new VideoCassette());

        assertThat(videoCassette.getId()).isNull();
        assertThat(videoCassette.getTitle()).isNull();
        assertThat(videoCassette.getProductionYear()).isNull();
        Assert.assertNotEquals(videoCassette.getTitle(), "Rambo");
        Assert.assertNotEquals(videoCassette.getProductionYear(), LocalDate.of(1993, 4, 5));

    }


}