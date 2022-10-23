package com.dio.poo;

import com.dio.poo.domain.model.Address;
import com.dio.poo.domain.model.Departament;
import com.dio.poo.domain.model.Employee;
import com.dio.poo.domain.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PooApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = Address.builder()
				.street("Rua Fulano")
				.district("Distrito Brasil")
				.number(15)
				.build();

		Employee employee = new Employee();
		employee.setDepartament(Departament.DEVELOPMENT);
		employee.setIsActive(true);
		employee.setWage(new BigDecimal("2750"));

		employee.setName("Fulano");
		employee.setAge(31);
		employee.setAddress(address);
		employee.setProfession("Development Java Jr");
	}
}
