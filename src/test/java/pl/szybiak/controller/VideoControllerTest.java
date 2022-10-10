package pl.szybiak.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import pl.szybiak.VideoApp1011ApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class VideoControllerTest extends VideoApp1011ApplicationTests {

    @Test
    @DisplayName("Should return list of Videocasette, at the least entry")
    void shouldReturnListOffVidoecassete() throws Exception {
        var url = "/cassetts/all";

        mockMvc.perform(get(url))
                .andDo(print())
                //then
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].productionYear").exists());


    }


}