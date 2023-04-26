package com.selfstudy.employeems.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 26/04/2023
 **/

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUtil {
    private String code;
    private String message;
    private Object content;
}
