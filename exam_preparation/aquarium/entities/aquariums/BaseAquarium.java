package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.isBlank() || name.equalsIgnoreCase("null")) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity <= getFish().size()) {
            throw new IllegalStateException("Not enough capacity.");
        }
        String fishWaterType = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if (!this.getClass().getSimpleName().contains(fishWaterType)) {
            throw new IllegalStateException(WATER_NOT_SUITABLE);
        }

        this.fish.add(fish);

    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);

    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);

    }

    @Override
    public void feed() {
        for (Fish f : fish) {
            f.eat();
        }
    }

    @Override
    public String getInfo() {

        String outputFish = fish.isEmpty() ? "none" :
                fish.stream().map(Fish::getName).collect(Collectors.joining(" "));

        StringBuilder builder = new StringBuilder(this.name + " (").append(getClass().getSimpleName()).append("):")
                .append(System.lineSeparator());
        builder.append("Fish: ").append(outputFish).append(System.lineSeparator());
        builder.append("Decorations: ").append(decorations.size()).append(System.lineSeparator());
        builder.append("Comfort: ").append(calculateComfort()).append(System.lineSeparator());
        return builder.toString();
    }


    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
