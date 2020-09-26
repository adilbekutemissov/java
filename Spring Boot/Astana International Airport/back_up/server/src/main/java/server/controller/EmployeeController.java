package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.EmployeeDto;
import server.model.EmployeeEntity;
import server.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public EmployeeEntity create(@RequestBody EmployeeDto employeeDto) {
        return service.create(employeeDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> employees(){
        return service.getAllEmployees();
    }

    @GetMapping(value="/getEmployeeById")
    public Optional<EmployeeEntity> get(@Validated @RequestParam("id") Integer id) {
        return service.getEmployeeByID(id);
    }
}
