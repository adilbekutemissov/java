package server.service;


import server.dto.EmployeeDto;
import server.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {

    EmployeeEntity create(EmployeeDto employeeDto);

    List<EmployeeEntity> getAllEmployees();
    Optional<EmployeeEntity> getEmployeeByID(int id);
    EmployeeEntity save(EmployeeEntity ticket);
    void delete(EmployeeEntity ticket);
}
