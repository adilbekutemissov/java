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
import server.dto.TicketDto;
import server.model.TicketEntity;
import server.repositories.PlaneRepository;
import server.repositories.TicketRepository;
import server.service.PlaneService;
import server.service.TicketService;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TicketControllerTest {
    protected MockMvc mockMvc;

    @Mock
    private TicketService service;

    @Mock
    private TicketController ticketController;

    @Mock
    private TicketRepository ticketRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_create_ticket_success() throws Exception {
        TicketDto ticket = new TicketDto();
        ticket.setPassengerid(1);
        ticket.setFlightid(2);
//        ticket.setPrice();
        ticket.setSeatnumber(25);
        mockMvc.perform(post("/ticket/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(ticket))).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }
/*    @Test
    public void test_delete_ticket_success() throws Exception {
        TicketEntity plane = new TicketEntity(1,2,12,25);
        ticketRepository.saveAndFlush(plane);
        mockMvc.perform(delete("/ticket/delete/?id=", ticket.getId())).andExpect(status().isOk());
        verifyNoMoreInteractions(service);
    }*/

}