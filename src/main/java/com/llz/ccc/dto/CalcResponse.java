package com.llz.ccc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalcResponse {
    private boolean success;
    private String expression;
    private double result;
}