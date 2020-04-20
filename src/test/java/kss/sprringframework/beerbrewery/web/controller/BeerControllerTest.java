package kss.sprringframework.beerbrewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kss.sprringframework.beerbrewery.services.BeerService;
import kss.sprringframework.beerbrewery.web.model.Beer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.management.ObjectName;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    Beer beer;

    @BeforeEach
    void setUp() {
        beer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("Style 1")
                .upc(678234L)
                .build();
    }

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(beer);

        mockMvc.perform(get("/api/v1/beer/" + beer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(beer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }

    @Test
    void saveNewBeer() throws Exception {

        Beer savedDto = Beer.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(savedDto);

        given(beerService.saveNewBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }


    @Test
    void updateBeer() throws Exception {
        Beer beerDto = beer;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v1/beer/" + beer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }
}