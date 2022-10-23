package com.dio.poo.storagy;

import com.dio.poo.domain.model.Employee;

public interface EmployeeService {

    void saveCSV(Employee employee);
    Employee findByNameCSV(String name);
    void deleteByNameCSV(String name);
}
