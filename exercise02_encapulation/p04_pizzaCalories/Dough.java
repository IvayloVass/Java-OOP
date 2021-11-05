package exercise02_encapulation.p04_pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("exercise02_encapulation.p04_pizzaCalories.Dough weight should be in the range [1..200].");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        double flourTypeModifier = getFlourModifier(this.flourType);
        double bakingTechniqueModifier = getBakingModifier(this.bakingTechnique);
        return (2 * this.weight) * flourTypeModifier * bakingTechniqueModifier;

    }

    private double getFlourModifier(String flourType) {

        if (flourType.equals("White")) {
            return 1.5;
        } else if (flourType.equals("Wholegrain")) {
            return 1.0;
        }
        return 0;
    }

    private double getBakingModifier(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
            default:
                return 0;
        }
    }
}

