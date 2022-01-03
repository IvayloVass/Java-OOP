package christmasRaces.core.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.CarRepository;
import christmasRaces.repositories.interfaces.DriverRepository;
import christmasRaces.repositories.interfaces.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = new DriverRepository();
        this.carRepository = new CarRepository();
        this.raceRepository = new RaceRepository();

    }

    @Override
    public String createDriver(String driver) {
        Driver myDriver = new DriverImpl(driver);
        if (driverRepository.getByName(driver) == null) {
            driverRepository.add(myDriver);
            return String.format(DRIVER_CREATED, driver);
        }
        throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
            default:
                return "Unavailable cat type!";
        }
        if (carRepository.getByName(model) == null) {
            carRepository.add(car);
            return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
        }
        throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        int laps = raceRepository.getByName(raceName).getLaps();
        List<Driver> sortedDrivers = driverRepository.getAll().stream()
                .sorted(Comparator.comparingDouble(d -> d.getCar().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());
        Collections.reverse(sortedDrivers);
        if (sortedDrivers.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        raceRepository.remove(raceRepository.getByName(raceName));

        StringBuilder output = new StringBuilder();
        output.append("Driver ").append(sortedDrivers.get(0).getName()).append(" wins ")
                .append(raceName).append(" race.").append(System.lineSeparator());
        output.append("Driver ").append(sortedDrivers.get(1).getName()).append(" is second in ")
                .append(raceName).append(" race.").append(System.lineSeparator());
        output.append("Driver ").append(sortedDrivers.get(2).getName()).append(" is third in ")
                .append(raceName).append(" race.");

        return output.toString();
    }
}
