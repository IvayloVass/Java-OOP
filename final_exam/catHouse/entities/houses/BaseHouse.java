package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity > cats.size()) {
            this.cats.add(cat);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);

    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }


    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":")
                .append(System.lineSeparator());
        output.append("Cats: ");
        if (this.cats.isEmpty()) {
            output.append("none");
        } else {
            for (Cat cat : cats) {
                output.append(cat.getName()).append(" ");
            }
        }
        output.append(System.lineSeparator());
        output.append("Toys: ").append(this.toys.size()).append(" Softness: ").append(this.sumSoftness());
        output.append(System.lineSeparator());

        return output.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
