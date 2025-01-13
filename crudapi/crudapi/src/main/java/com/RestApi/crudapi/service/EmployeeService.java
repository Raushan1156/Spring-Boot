package com.RestApi.crudapi.service;

import com.RestApi.crudapi.config.ModelMapperConfig;
import com.RestApi.crudapi.dto.employeeDto;
import com.RestApi.crudapi.entity.entity;
import com.RestApi.crudapi.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    final private EmployeeRepo employeeRepo;
    final private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper){
        this.employeeRepo=employeeRepo;
        this.modelMapper=modelMapper;
    }

    public employeeDto getEmployeeById(Long id){
        entity ent= employeeRepo.findById(id).orElse(null);
        return modelMapper.map(ent,employeeDto.class);
//      return new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));

    }

    public List<employeeDto> getAllEmployee(){
        List<entity> employees= employeeRepo.findAll();
        System.out.println(employees);

        // Traditional method
//        List<employeeDto> dtoReturnVal= new ArrayList<>();
//        for(entity ent:employees){
//            //This is the one way to change the object type from entity to dto. Better if we use ModalMapper.
//            dtoReturnVal.add(new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));
//        }
//        return dtoReturnVal;
        return employees.stream()
                .map(employee-> modelMapper.map(employee, employeeDto.class))
                .collect(Collectors.toList());
    }

}
