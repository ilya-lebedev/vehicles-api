package com.udacity.vehicles.loader;

import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarRepository;
import com.udacity.vehicles.domain.car.Details;
import com.udacity.vehicles.domain.manufacturer.Manufacturer;
import com.udacity.vehicles.domain.manufacturer.ManufacturerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DataLoader implements ApplicationRunner {

    private ManufacturerRepository repository;
    private CarRepository carRepository;

    public DataLoader(ManufacturerRepository repository, CarRepository carRepository) {
        this.repository = repository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Manufacturer audi = repository.save(new Manufacturer(100, "Audi"));
        Manufacturer chevrolet = repository.save(new Manufacturer(101, "Chevrolet"));
        Manufacturer ford = repository.save(new Manufacturer(102, "Ford"));
        Manufacturer bmw = repository.save(new Manufacturer(103, "BMW"));
        Manufacturer dodge = repository.save(new Manufacturer(104, "Dodge"));

        Details a4Details = new Details();
        a4Details.setBody("A4 Details");
        a4Details.setModel("A4");
        a4Details.setManufacturer(audi);

        Location a4Location = new Location(98.67, 15.34);

        Car a4 = new Car();
        a4.setDetails(a4Details);
        a4.setLocation(a4Location);
        a4.setCondition(Condition.NEW);

        carRepository.save(a4);
    }

}
