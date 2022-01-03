package christmasRaces.repositories.interfaces;

import christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public void add(Race model) {
        this.races.add(model);
    }

    @Override
    public Race getByName(String name) {
        return races.stream().filter(r -> r.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public boolean remove(Race model) {
        return races.remove(model);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }
}
