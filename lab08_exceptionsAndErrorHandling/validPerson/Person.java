package lab08_exeptionsAndErrorHandling.validPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public void setFirstName(String firstName) {
        if (firstName.isBlank()) {
            throw new IllegalArgumentException("The first name cannot be null or empty!");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.isBlank()) {
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in range [0...120]");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("My name is %s, my father's name is %s and I am %d years old!\n",
                this.firstName, this.lastName, this.age);
    }
}
