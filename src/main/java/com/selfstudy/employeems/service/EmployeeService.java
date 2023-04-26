package com.selfstudy.employeems.service;

import com.selfstudy.employeems.dto.EmployeeDTO;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 25/04/2023
 **/
public interface EmployeeService {
    String saveEmployee(EmployeeDTO employeeDTO);

    String updateEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO searchEmployee(int id);

    String deleteEmployee(int id);
}
