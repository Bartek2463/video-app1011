package pl.szybiak.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import pl.szybiak.VideoApp1011ApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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

    @Test
    @DisplayName("Should return one entry")
    void shouldReturnOneCategory() throws Exception{
        //given
        var id = 1L;
        var url = "/cassetts/"+id;

        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(id));

    }
    @Test
    @DisplayName("Should create new Videocassete")
    void shouldPostAddCategoryWithCreated() throws Exception {
        var url = "/videocassette";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"id" : null,"title" : "Impossible","productionYear" : "1993-01-02"}
                                """))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}