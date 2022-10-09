package com.dio.poo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Employee extends Person{

    private String departament;
    private Boolean isActive;
    private BigDecimal wage;
}
