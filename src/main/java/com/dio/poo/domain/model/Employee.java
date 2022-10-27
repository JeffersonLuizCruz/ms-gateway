package com.dio.poo.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Employee extends Person{
    private Departament departament;
    private Boolean isActive;
    private BigDecimal wage;
}
