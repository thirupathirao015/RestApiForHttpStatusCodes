package com.example.RestApiExample.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApiExample.modal.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
