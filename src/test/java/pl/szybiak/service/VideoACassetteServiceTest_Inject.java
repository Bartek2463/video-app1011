package pl.szybiak.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import pl.szybiak.repository.VideoAssettsRepository;

@RunWith(MockitoJUnitRunner.class)
class VideoACassetteServiceTest_Inject {

    @Mock
    VideoAssettsRepository videoAssettsRepository;
    @InjectMocks
    VideoACassetteService videoACassetteService;

    @Test
    public void save() {
        System.out.println();
    }
}