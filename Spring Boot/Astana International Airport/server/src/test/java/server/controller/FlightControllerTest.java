package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import server.dto.FlightDto;
import server.model.FlightEntity;
import server.repositories.FlightRepository;
import server.service.FlightService;

import java.sql.Timestamp;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FlightControllerTest {
    protected MockMvc mockMvc;

    @Mock
    private FlightService service;

    @Mock
    private FlightController flightController;

    @Mock
    private FlightRepository flightRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_create_flight_success() throws Exception {
        FlightDto flight = new FlightDto();
        flight.setPlaneid(2);
        flight.setAirlineid(1);
        flight.setDepartmentdate(Timestamp.valueOf("2018-12-26 21:04:58"));
        flight.setArrilvalsdate(Timestamp.valueOf("2018-12-26 22:04:58"));
        flight.setDepartment("Rome");
        flight.setArrival("Astana");
        flight.setDistance(123);
        flight.setTerminalid(1);
        mockMvc.perform(post("/flight/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(flight))).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }
    /*@Test
    public void test_delete_flight_success() throws Exception {
        FlightEntity flight = new FlightEntity(2,1,"2018-12-26 21:04:58", "2018-12-26 21:04:58", "Rome", "Astana", 123,1);
        flightRepository.saveAndFlush(flight);
        mockMvc.perform(delete("/flight/delete/?id=", flight.getId())).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }*/

}