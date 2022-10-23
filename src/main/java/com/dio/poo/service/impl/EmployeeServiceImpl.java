package com.dio.poo.service.impl;

import com.dio.poo.domain.model.Departament;
import com.dio.poo.domain.model.Employee;
import com.dio.poo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Value("${header.csv.user}")
    private String headerCSV;
    @Value("${path.user.csv}")
    private String path;
    UUID uuid = UUID.randomUUID();

    private final String SEPARATOR = "\r\n";
    @Override
    public void saveCSV(Employee employee) {

        Departament departament = employee.getDepartament();
        Boolean isActive = employee.getIsActive();
        employee.getWage();

        employee.getName();
        employee.getAge();
        employee.getAddress();
        employee.getProfession();

        Path pathcsv = Paths.get(path);
        String content = "teste teste ste";

        try {
            if(Files.notExists(pathcsv.resolve("user"))){
                Path pathCsvUser = Files.createDirectories(pathcsv.resolve("user"));

                Path file = Files.createFile(pathCsvUser.resolve("user-" + uuid + ".csv"));
                Files.writeString(file, String.format("%s, %s, %s", headerCSV, SEPARATOR, content), StandardCharsets.UTF_8);
            }else{
                Path file = Files.createFile(pathcsv.resolve("user\\user-" + uuid + ".csv"));
                Files.writeString(file, String.format("%s, %s, %s", headerCSV, SEPARATOR, content), StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee findByNameCSV(String name) {
        return null;
    }

    @Override
    public void deleteByNameCSV(String name) {

    }
}
