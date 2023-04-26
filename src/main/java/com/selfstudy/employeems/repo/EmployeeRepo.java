package com.selfstudy.employeems.repo;

import com.selfstudy.employeems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 25/04/2023
 **/
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
