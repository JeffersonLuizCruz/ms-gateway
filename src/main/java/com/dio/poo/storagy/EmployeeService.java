package com.dio.poo.storagy;

import com.dio.poo.domain.model.Employee;

public interface EmployeeService {

    void save(Employee employee);
    Employee findByName(String name);
    void deleteByName(String name);
}
