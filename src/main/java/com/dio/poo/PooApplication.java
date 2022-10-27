package com.dio.poo;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dio.poo.domain.model.Address;
import com.dio.poo.domain.model.Departament;
import com.dio.poo.domain.model.Employee;
import com.dio.poo.service.EmployeeService;

@SpringBootApplication
public class PooApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);
	}

	@Autowired
	EmployeeService employeeService;
	
	
	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		Address address = new Address();
		Employee employee = new Employee();
		
		System.out.println("Informe seu endereço:");
		String street = input.nextLine();
		address.setStreet(street);
		
		System.out.println("Informe seu Estado:");
		String district = input.nextLine();
		address.setDistrict(district);
		
		System.out.println("Informe o número:");
		int number = input.nextInt();
		address.setNumber(number);
	
		System.out.println("Informe sua profissão:");
		String professiton = input.nextLine();
		employee.setProfession(professiton);
		
		System.out.println("Informe seu salário:");
		String wage = input.next();
		employee.setWage(new BigDecimal(wage));

		employee.setAddress(address);
		employee.setDepartament(Departament.DEVELOPMENT);
		employee.setIsActive(true);
		
		employeeService.saveCSV(employee);
	}
	
//	private Address getAdress(Scanner input, Address address) {
//		System.out.println("#### CADASTRO - Endereço ####");
//		System.out.print("Informe seu endereço: ");
//		String street = input.nextLine();
//		address.setStreet(street);
//		
//		System.out.print("Informe seu Estado: ");
//		String district = input.nextLine();
//		address.setDistrict(district);
//		
//		System.out.print("Informe o número: ");
//		int number = input.nextInt();
//		address.setNumber(number);
//		
//		return address;
//	}
}
