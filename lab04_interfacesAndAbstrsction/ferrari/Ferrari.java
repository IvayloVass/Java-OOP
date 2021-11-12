package lab04_interfacesAndAbstrsction.ferrari;

public class Ferrari implements Car {
    private final String driverName;
    private final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getMODEL() {
        return MODEL;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    //"{model}/{brakes}/{gas}/{driver's name
    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, brakes(), gas(), this.driverName);
    }
}
