package com.bnb3.controlloer;

import com.bnb3.entity.Employee;
import com.bnb3.payload.EmployeeDto;
import com.bnb3.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto, BindingResult result) {
        if(result.hasErrors()) {
       return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("100");
        System.out.println("200");
    System.out.println(300);
    System.out.println(400);
        EmployeeDto empDto = employeeService.addEmployee(dto);
        return new ResponseEntity<>(empDto, HttpStatus.CREATED);
}
@DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestParam(name="pageSize",required=false,defaultValue = "5") int pageSize
    ,@RequestParam(name="pageNo",required=false,defaultValue = "0")int pageNo,
                                                          @RequestParam(name="sortBy",required=false,defaultValue="name")String sortBy,
                                                          @RequestParam(name="sortDir",required=false,defaultValue = "asc")String sortDir){
      List<EmployeeDto> employeeDto =   employeeService.getEmployees(pageSize, pageNo,sortBy,sortDir);
      return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam long id,@RequestBody EmployeeDto dto){
        EmployeeDto employeeDto = employeeService.updateEmployee(id, dto);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    @GetMapping("/employeeId{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long empId){
       EmployeeDto dto = employeeService.getEmployeeById(empId) ;
       return new ResponseEntity<>(dto,HttpStatus.OK) ;
    }
}
