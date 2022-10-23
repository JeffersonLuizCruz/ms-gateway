package com.dio.poo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public abstract class Person {
    private String name;
    private int age;
    private Address address;
    private String profession;

}
