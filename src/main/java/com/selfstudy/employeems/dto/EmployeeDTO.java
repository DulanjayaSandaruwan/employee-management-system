package com.selfstudy.employeems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 25/04/2023
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String address;
    private String mobileNumber;
}
