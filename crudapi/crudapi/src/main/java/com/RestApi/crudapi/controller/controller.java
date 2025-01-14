package com.RestApi.crudapi.controller;

import com.RestApi.crudapi.dto.EmployeeDto;
import com.RestApi.crudapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
//        if (id <= employee.size()-1)
//            return employee.get(id.intValue()-1);
//        else
//            return "Your " + id + " doesn't exist";
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto){
//        employee.add(name);
//    return " added name: "+name;
        return employeeService.createNewEmployee(employeeDto);
    }

    @PutMapping("/{employeeID}")
    public EmployeeDto updateEmployee(@PathVariable (name = "employeeID") Long id, @RequestBody EmployeeDto employeeDto){
//        employee.set(id.intValue()-1,name);
//        return employee;

        return employeeService.updateEmployeeById(id,employeeDto);
    }

    @PatchMapping("/{empId}")
    public EmployeeDto updatePatchValue(@PathVariable (name="empId") Long id, @RequestBody Map<String,Object> employeeDto){
        return employeeService.updatePatchValue(id,employeeDto);
    }

    @DeleteMapping("/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
//        if (!employee.isEmpty()){
//            employee.removeLast();
//        return employee;
//        }
//        else{
//            employee.add("employe is empty");
//            return employee;
//        }
        return employeeService.deleteEmployeeById(employeeId);
    }

}

@RestController
class ErrorHandler {
    @GetMapping("/")
    public String errorHandler() {
        return "Please enter the correct api.";
    }


}
