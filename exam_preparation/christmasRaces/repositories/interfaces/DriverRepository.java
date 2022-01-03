package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {

    private Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public void add(Driver model) {
        this.drivers.add(model);
    }

    @Override
    public Driver getByName(String name) {
        return drivers.stream().filter(d -> d.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public boolean remove(Driver model) {
        return this.drivers.remove(model);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.drivers);
    }

}
