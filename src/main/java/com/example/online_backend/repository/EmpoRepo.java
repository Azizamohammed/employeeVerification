package com.example.online_backend.repository;

import com.example.online_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpoRepo extends JpaRepository<Employee, Integer> {

}
