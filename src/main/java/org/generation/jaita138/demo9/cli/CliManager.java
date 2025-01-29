package org.generation.jaita138.demo9.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo9.db.entity.Car;
import org.generation.jaita138.demo9.db.entity.Park;
import org.generation.jaita138.demo9.db.service.CarService;
import org.generation.jaita138.demo9.db.service.ParkService;

public class CliManager {

    private Scanner scanner;

    private CarService carService;
    private ParkService parkService;

    public CliManager(CarService carService, ParkService parkService) {
        this.carService = carService;
        this.parkService = parkService;

        scanner = new Scanner(System.in);

        printOptions();
    }

    private void printOptions() {

        System.out.println("Operazioni:");
        System.out.println("1. Visualizza tutte le auto");
        System.out.println("2. Inserisci nuova auto");
        System.out.println("3. Modifica un auto esistente");
        System.out.println("4. Elimina un auto esistente");
        System.out.println("5. Esci");
        System.out.println("");

        String strUserValue = scanner.nextLine();
        int userValue = Integer.parseInt(strUserValue);

        switch (userValue) {

            case 1:
                printCars();
                break;
            case 2:
                insertCar();
                break;

            case 3:
                updateCar();
                break;

            case 4:
                deleteCar();
                break;

            case 5:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void printCars() {

        List<Car> cars = carService.findAll();
        System.out.println("");
        System.out.println("Auto");
        System.out.println(cars);
        System.out.println("");
        printSeparetor();
    }

    private void insertCar() {

        Car car = new Car();

        System.out.println("brand");
        String brand = scanner.nextLine();
        car.setBrand(brand);

        System.out.println("model");
        String model = scanner.nextLine();
        car.setModel(model);

        System.out.println("year");
        String strYear = scanner.nextLine();
        int year = Integer.parseInt(strYear);
        car.setYear(year);

        System.out.println("price");
        String strPrice = scanner.nextLine();
        int price = Integer.parseInt(strPrice);
        car.setPrice(price);

        System.out.println("displacement");
        String strDisplacement = scanner.nextLine();
        int displacement = Integer.parseInt(strDisplacement);
        car.setDisplacement(displacement);

        System.out.println("parks");
        List<Park> parks = parkService.findAll();
        System.out.println(parks);
        printSeparetor();
        System.out.println("park id");
        String strParkId = scanner.nextLine();
        Long parkId = Long.parseLong(strParkId);
        Park park = parkService.findById(parkId);
        car.setPark(park);

        carService.save(car);
    }

    private void updateCar() {

        System.out.println("car id");
        String strId = scanner.nextLine();
        Long id = Long.parseLong(strId);
        Car car = carService.findById(id);

        if (car == null) {
            System.out.println("auto non trovata");
            return;
        }

        System.out.println("brand (" + car.getBrand() + ")");
        String brand = scanner.nextLine();
        car.setBrand(brand);

        System.out.println("model (" + car.getModel() + ")");
        String model = scanner.nextLine();
        car.setModel(model);

        System.out.println("year (" + car.getYear() + ")");
        String strYear = scanner.nextLine();
        int year = Integer.parseInt(strYear);
        car.setYear(year);

        System.out.println("price (" + car.getPrice() + ")");
        String strPrice = scanner.nextLine();
        int price = Integer.parseInt(strPrice);
        car.setPrice(price);

        System.out.println("displacement (" + car.getDisplacement() + ")");
        String strDisplacement = scanner.nextLine();
        int displacement = Integer.parseInt(strDisplacement);
        car.setDisplacement(displacement);

        carService.save(car);
    }

    private void deleteCar() {

        System.out.println("car id");
        String strId = scanner.nextLine();
        Long id = Long.parseLong(strId);
        Car car = carService.findById(id);

        if (car == null) {
            System.out.println("auto non trovata");
            return;
        }

        carService.delete(car);
    }

    private void printSeparetor() {
        System.out.println("------------------------------------------------");
    }
}
