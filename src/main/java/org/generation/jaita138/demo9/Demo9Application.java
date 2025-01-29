package org.generation.jaita138.demo9;

import java.util.List;

import org.checkerframework.checker.units.qual.kN;
import org.generation.jaita138.demo9.cli.CliManager;
import org.generation.jaita138.demo9.db.entity.Car;
import org.generation.jaita138.demo9.db.service.CarService;
import org.generation.jaita138.demo9.db.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo9Application implements CommandLineRunner {

	@Autowired
	private CarService carService;

	@Autowired
	private ParkService parkService;

	public static void main(String[] args) {
		SpringApplication.run(Demo9Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// test();

		new CliManager(carService, parkService);
	}

	private void test() {

		Car car = new Car();

		car.setBrand("Fiat");
		car.setModel("Panda");

		car.setYear(2021);
		car.setPrice(10000);

		car.setDisplacement(900);

		System.out.println("Car before save");
		System.out.println(car);
		printSeparetor();

		carService.save(car);

		System.out.println("Car after save");
		System.out.println(car);
		printSeparetor();

		List<Car> cars = carService.findAll();

		System.out.println("Cars");
		System.out.println(cars);
		printSeparetor();

		Car car2 = carService.findById(2L);

		System.out.println("Car by id 2");
		System.out.println(car2);
		printSeparetor();

		carService.delete(car2);
	}

	private void printSeparetor() {
		System.out.println("------------------------------------------------");
	}
}
