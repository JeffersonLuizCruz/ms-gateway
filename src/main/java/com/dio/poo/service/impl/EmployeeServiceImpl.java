package com.dio.poo.service.impl;

import com.dio.poo.domain.model.Address;
import com.dio.poo.domain.model.Departament;
import com.dio.poo.domain.model.Employee;
import com.dio.poo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
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

    private final String lINE_BREAK = "\r\n";
    private final String SEPARATOR = ",";
    @Override
    public void saveCSV(Employee employee) {

        Path pathcsv = Paths.get(path);
        String content = getContent(employee);

        try {
            if(Files.notExists(pathcsv.resolve("user"))){
                Path pathCsvUser = Files.createDirectories(pathcsv.resolve("user"));

                Path file = Files.createFile(pathCsvUser.resolve("user-" + uuid + ".csv"));
                Files.writeString(file, String.format("%s, %s, %s", headerCSV, lINE_BREAK, content), StandardCharsets.UTF_8);
            }else{
                Path file = Files.createFile(pathcsv.resolve("user\\user-" + uuid + ".csv"));
                Files.writeString(file, String.format("%s %s %s", headerCSV, lINE_BREAK, content), StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getContent(Employee employee) {
        String valueStr = "";

        valueStr += employee.getDepartament() != null ? Departament.DEVELOPMENT + SEPARATOR : "" + SEPARATOR;
        valueStr += employee.getIsActive() != null ? String.valueOf(employee.getIsActive()) + SEPARATOR : "" + SEPARATOR;
        valueStr += employee.getName() != null ? employee.getName() + SEPARATOR: "" + SEPARATOR;
        valueStr += employee.getAge() != null ? String.valueOf(employee.getAge()) + SEPARATOR: "" + SEPARATOR;
        valueStr += employee.getAddress() != null ? concatValueAdsress(employee.getAddress()) + SEPARATOR : "" + SEPARATOR;
        valueStr += employee.getProfession() != null ? employee.getProfession() + SEPARATOR : "" + SEPARATOR;
        valueStr += employee.getWage() != null ? String.valueOf(employee.getWage()) + SEPARATOR: "" + SEPARATOR;

        return valueStr;
    }

    private String concatValueAdsress(Address address) {
        String valueStr = "";
        valueStr += address.getDistrict() != null ? address.getDistrict() + "|" : "";
        valueStr += address.getStreet() != null ? address.getStreet() + "|" : "";
        valueStr += address.getNumber() != null ? String.valueOf(address.getNumber()) + "|" : "";

        return valueStr;
    }

    @Override
    public Employee findByNameCSV(String name) {
        return null;
    }

    @Override
    public void deleteByNameCSV(String name) {

    }
}
