package com.RestApi.crudapi.controller;

import com.RestApi.crudapi.dto.EmployeeDto;
import com.RestApi.crudapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class controller {

    private final EmployeeService employeeService;
    public controller(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    ArrayList<String> employee=new ArrayList<>(Arrays.asList("Raushan","Ramesh", "Rohan"));

    @GetMapping()
    public List<EmployeeDto> getAllEmployee(){
//        List<entity> returnValue= employeeService.findAll();
//        System.out.println(returnValue);
//        List<employeeDto> dtoReturnVal= new ArrayList<>();
//        for(entity ent:returnValue){
//            dtoReturnVal.add(new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));
//        }
    return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        if (id <= employee.size()-1)
            return employee.get(id.intValue()-1);
        else
            return "Your " + id + " doesn't exist";
    }

    @PostMapping()
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto){
//        employee.add(name);
//    return " added name: "+name;
        return employeeService.createNewEmployee(employeeDto);
    }

    @PutMapping("/update/{employeeID}")
    public EmployeeDto updateEmployee(@PathVariable (name = "employeeID") Long id, @RequestBody EmployeeDto employeeDto){
//        employee.set(id.intValue()-1,name);
//        return employee;

        return employeeService.updateEmployeeById(id,employeeDto);
    }

    @DeleteMapping("/delete")
    public ArrayList<String> deleteEmployee() {
        if (!employee.isEmpty()){
            employee.removeLast();
        return employee;
        }
        else{
            employee.add("employe is empty");
            return employee;
        }

    }

}

@RestController
class ErrorHandler {
    @GetMapping("/")
    public String errorHandler() {
        return "Please enter the correct api.";
    }


}
