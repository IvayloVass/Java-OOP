package lab08_exeptionsAndErrorHandling.validPerson;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.email = email;
    }

    private void setName(String name) {
        for (char symbol : name.toCharArray()) {
            if (!Character.isLetter(symbol)) {
                throw new InvalidPersonNameException("Name does not allow any special character or numeric value");
            }
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return String.format("I am %s, my email is %s", this.name, this.email);
    }
}
