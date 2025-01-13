package com.RestApi.crudapi.repository;

import com.RestApi.crudapi.dto.employeeDto;
import com.RestApi.crudapi.entity.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<entity,Long> {
}
