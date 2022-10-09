package com.dio.poo.storagy.impl;

import com.dio.poo.domain.model.Employee;
import com.dio.poo.storagy.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findByName(String name) {
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }
}
