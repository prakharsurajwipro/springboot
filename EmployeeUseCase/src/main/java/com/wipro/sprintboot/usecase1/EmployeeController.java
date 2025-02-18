package com.wipro.sprintboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") 
@RestController //  Ensures JSON output
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //  Fetch all employees in JSON format
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
