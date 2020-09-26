package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import server.dto.EmployeeDto;
import server.dto.TicketDto;
import server.repositories.EmployeeRepository;
import server.repositories.TicketRepository;
import server.service.EmployeeService;
import server.service.TicketService;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerTest {
    protected MockMvc mockMvc;

    @Mock
    private EmployeeService service;

    @Mock
    private EmployeeController employeeController;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_create_employee_success() throws Exception {
        EmployeeDto employee = new EmployeeDto();
        employee.setAirlineid(1);
        employee.setEmail("utemissov.a@mail.kz");
        employee.setPassword("123456");
        employee.setPhonenumber(776777899);
        mockMvc.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON).content(asJsonString(employee))).andExpect(status().isOk());
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