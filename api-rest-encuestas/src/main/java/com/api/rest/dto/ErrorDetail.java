package com.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private Long timeStamp;
    private String developerMessage;

    private Map<String, List<ValidationError>> errors = new HashMap<>();
}
