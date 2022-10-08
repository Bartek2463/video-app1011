package pl.szybiak.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.szybiak.repository.VideoAssettsRepository;

@ExtendWith(MockitoExtension.class)
class VideoACassetteServiceTest_Inject {

    @Mock
    VideoAssettsRepository videoAssettsRepository;

    @InjectMocks
    VideoACassetteService videoACassetteService;


    @Test
    public void addVideocassets(){
        System.out.println();
    }
    @Test
    public void addVideocassetsr(){
        System.out.println();
    }
}