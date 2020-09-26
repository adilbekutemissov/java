package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import server.dto.PassengerDto;
import server.model.PassengerEntity;
import server.repositories.PassengerRepository;
import server.service.PassengerService;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PassengerControllerTest {
    protected MockMvc mockMvc;

    @Mock
    private PassengerService service;

    @Mock
    private PassengerController passengerController;

    @Mock
    private PassengerRepository passengerRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(passengerController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_create_passenger_success() throws Exception {
        PassengerDto passenger = new PassengerDto();
        passenger.setName("Adilbek");
        passenger.setSurname("Utemissov");
        passenger.setEmail("utemiadi@fel.cvut.cz");
        passenger.setPassword("aaa");
        passenger.setPhonenumber(123);
        mockMvc.perform(post("/passenger/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(passenger))).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }
    /*@Test
    public void test_getAll_passengers_success() throws Exception {
        mockMvc.perform(get("/passenger/getAllPassengers").contentType(MediaType.APPLICATION_JSON).content(asJsonString(passenger))).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }*/
    /*@Test
    public void test_delete_passenger_success() throws Exception {
        PassengerEntity passenger = new PassengerEntity("Andrej","Zhikulin","zhikuand@fel.cvut.cz","fers",538);
        passengerRepository.saveAndFlush(passenger);
        mockMvc.perform(delete("/passenger/delete/?id=", passenger.getId())).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }*/

}