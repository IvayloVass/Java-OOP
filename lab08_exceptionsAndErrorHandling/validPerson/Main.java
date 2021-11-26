package lab08_exeptionsAndErrorHandling.validPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person person = createPersonInstance("Mitak", "Petrov", 0);
            System.out.println(person);
            Student student = new Student("Peshi4_69", "myEmail@com");
            System.out.println(student);
        } catch (InvalidPersonNameException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Person createPersonInstance(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }
}
