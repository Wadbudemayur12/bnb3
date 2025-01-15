package com.bnb3.service;

import com.bnb3.entity.Employee;
import com.bnb3.exception.NoResourceFound;
import com.bnb3.payload.EmployeeDto;
import com.bnb3.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    //create method to add employee for employee entity

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;

        this.modelMapper = modelMapper;
    }

    public EmployeeDto addEmployee(EmployeeDto  dto) {
        Employee employee = mapToEntity(dto);
        Employee emp = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(employee);
     return employeeDto;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);  //delete employee from database using Spring Data JPA Repository
    }

    public List<EmployeeDto> getEmployees(int  pageSize, int pageNo, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc")?Sort.by(sortDir).ascending():Sort.by(sortDir).descending();
        Pageable page = PageRequest.of(pageSize, pageNo, sort);
        Page<Employee> employee = employeeRepository.findAll(page);
        List<Employee> employees  = employee.getContent();
        List<EmployeeDto> employeeDto = employee.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return employeeDto;
    }

    public EmployeeDto updateEmployee(long id, EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        employee.setId(id);
        employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(employee);
        return employeeDto;
    }

    EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
        return dto;
    }

    Employee mapToEntity(EmployeeDto dto){
        Employee emp =modelMapper.map(dto, Employee.class);
        return emp;
    }

    public EmployeeDto getEmployeeById(long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()->new NoResourceFound("No record found for employee id : " + empId));
;
        EmployeeDto employeeDto = mapToDto(employee);
        return employeeDto;
    }
}
