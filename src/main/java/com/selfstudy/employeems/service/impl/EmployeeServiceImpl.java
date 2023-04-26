package com.selfstudy.employeems.service.impl;

import com.selfstudy.employeems.dto.EmployeeDTO;
import com.selfstudy.employeems.entity.Employee;
import com.selfstudy.employeems.repo.EmployeeRepo;
import com.selfstudy.employeems.service.EmployeeService;
import com.selfstudy.employeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 25/04/2023
 **/

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getId())) {
            return VarList.RSP_DUPLICATED;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getId())) {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>() {
        }.getType());
    }

    @Override
    public EmployeeDTO searchEmployee(int id) {
        if (employeeRepo.existsById(id)){
            Employee employee =employeeRepo.findById(id).orElse(null);
            return modelMapper.map(employee,EmployeeDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public String deleteEmployee(int empID){
        if (employeeRepo.existsById(empID)){
            employeeRepo.deleteById(empID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
