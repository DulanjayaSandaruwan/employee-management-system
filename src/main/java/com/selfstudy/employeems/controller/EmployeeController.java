package com.selfstudy.employeems.controller;

import com.selfstudy.employeems.dto.EmployeeDTO;
import com.selfstudy.employeems.service.EmployeeService;
import com.selfstudy.employeems.util.ResponseUtil;
import com.selfstudy.employeems.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 25/04/2023
 **/

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseUtil responseUtil;

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.saveEmployee(employeeDTO);
            if (res.equals("00")) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(employeeDTO);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseUtil.setCode(VarList.RSP_DUPLICATED);
                responseUtil.setMessage("Already Registered");
                responseUtil.setContent(employeeDTO);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            } else {
                responseUtil.setCode(VarList.RSP_FAIL);
                responseUtil.setMessage("Error");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.updateEmployee(employeeDTO);
            if (res.equals("00")) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(employeeDTO);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseUtil.setCode(VarList.RSP_NO_DATA_FOUND);
                responseUtil.setMessage("Not a registered employee");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            } else {
                responseUtil.setCode(VarList.RSP_FAIL);
                responseUtil.setMessage("Error");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity getAllEmployees() {
        try {
            List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
            responseUtil.setCode(VarList.RSP_SUCCESS);
            responseUtil.setMessage("Success");
            responseUtil.setContent(employeeDTOList);
            return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(null);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchEmployee/{empID}")
    public ResponseEntity searchEmployee(@PathVariable int empID) {
        try {
            EmployeeDTO employeeDTO = employeeService.searchEmployee(empID);
            if (employeeDTO != null) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(employeeDTO);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else {
                responseUtil.setCode(VarList.RSP_NO_DATA_FOUND);
                responseUtil.setMessage("No Employee Available For this empID");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(e);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmployee/{empID}")
    public ResponseEntity deleteEmployee(@PathVariable int empID) {
        try {
            String res = employeeService.deleteEmployee(empID);
            if (res.equals("00")) {
                responseUtil.setCode(VarList.RSP_SUCCESS);
                responseUtil.setMessage("Success");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.ACCEPTED);
            } else {
                responseUtil.setCode(VarList.RSP_NO_DATA_FOUND);
                responseUtil.setMessage("No Employee Available For this empID");
                responseUtil.setContent(null);
                return new ResponseEntity(responseUtil, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseUtil.setCode(VarList.RSP_ERROR);
            responseUtil.setMessage(e.getMessage());
            responseUtil.setContent(e);
            return new ResponseEntity(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
