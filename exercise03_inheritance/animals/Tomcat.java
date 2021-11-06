package exercise03_inheritance.animals;

public class Tomcat extends Cat {
    private static final String TOM_CAT_GENDER = "Male";

    public Tomcat(String name, int age, String gender) {
        super(name, age, TOM_CAT_GENDER);
    }

    public Tomcat(String name, int age) {
        super(name, age, TOM_CAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
