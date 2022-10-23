package com.dio.poo.storagy.impl;

import com.dio.poo.domain.model.Employee;
import com.dio.poo.storagy.EmployeeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void saveCSV(Employee employee) {

        Path path = Paths.get("C:\\Users\\jlcru\\JEE-Intellij");
        UUID uuid = UUID.randomUUID();

        try {
            if(Files.notExists(path.resolve("storagy"))){
                path = Files.createDirectory(path.resolve("storagy"));

                Path file = Files.createFile(path.resolve("user-" + uuid + ".csv"));
                Files.writeString(file, "teste de criação de arquivo-noExist", StandardCharsets.UTF_8);
            }else{
                Path file = Files.createFile(path.resolve("storagy\\user-" + uuid + ".csv"));
                Files.writeString(file, "teste de criação de arquivo-exist");
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
