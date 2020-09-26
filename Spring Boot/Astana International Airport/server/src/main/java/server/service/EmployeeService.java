package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dto.EmployeeDto;
import server.model.EmployeeEntity;
import server.repositories.EmployeeRepository;
import server.service.Interfaces.EmployeeServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeEntity create(EmployeeDto employeeDto) {
        return repository.saveAndFlush(employeeDto.toEntity());
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }
    @Override
    public Optional<EmployeeEntity> getEmployeeByID(int id) {
        return repository.findById(id);
    }
    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return repository.saveAndFlush(employee);
    }
    @Override
    public void delete(EmployeeEntity employee) {
        repository.delete(employee);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
}
