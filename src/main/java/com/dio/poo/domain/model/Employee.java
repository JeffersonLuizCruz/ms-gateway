package com.dio.poo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Employee extends Person{
    private Departament departament;
    private Boolean isActive;
    private BigDecimal wage;
}
