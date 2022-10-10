package pl.szybiak.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.szybiak.repository.VideoAssettsRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class VideoACassetteServiceTest {

    @InjectMocks
    private VideoAssettsRepository videoAssettsRepository;

    @Mock
    private VideoACassetteService videoACassetteService;




    @Test
    void findById() {
        System.out.println();

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