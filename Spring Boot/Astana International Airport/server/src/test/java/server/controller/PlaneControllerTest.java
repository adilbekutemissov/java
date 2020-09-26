package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import server.dto.PlaneDto;
import server.repositories.PlaneRepository;
import server.service.PlaneService;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlaneControllerTest {
    protected MockMvc mockMvc;

    @Mock
    private PlaneService service;

    @Mock
    private PlaneController planeController;

    @Mock
    private PlaneRepository planeRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(planeController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_create_plane_success() throws Exception {
        PlaneDto plane = new PlaneDto();
        plane.setAirlineid(561);
        mockMvc.perform(post("/plane/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(plane))).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }
    /*@Test
    public void test_delete_plane_success() throws Exception {
        PlaneEntity plane = new PlaneEntity(561);
        planeRepository.saveAndFlush(plane);
        mockMvc.perform(delete("/plane/delete/?id=", plane.getId())).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }*/

}