package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {

    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public void add(Car model) {
        this.cars.add(model);
    }

    @Override
    public Car getByName(String name) {
        return cars.stream().filter(c -> c.getModel().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public boolean remove(Car model) {
        return cars.remove(model);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }
}
