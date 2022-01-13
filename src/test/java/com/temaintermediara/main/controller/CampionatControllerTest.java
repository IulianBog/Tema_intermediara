package com.temaintermediara.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temaintermediara.main.model.Campionat;
import com.temaintermediara.main.repositories.CampionatRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = CampionatController.class)
class CampionatControllerTest {

    @MockBean
    private CampionatRepository campionatRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test creating a campionat - success")
    void test_add_campionat() throws Exception {
        Campionat campionat = new Campionat();
        campionat.setNume("lala");
        when(campionatRepository.save(campionat)).thenReturn(campionat);

        MvcResult result = mockMvc.perform(post("/Campionat")
                        .content(objectMapper.writeValueAsString(campionat))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(campionat));
    }

}