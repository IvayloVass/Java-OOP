package lab04_interfacesAndAbstrsction.carShop;

public interface Rentable extends Car {

    Integer getMinRentDay();
    Double getPricePerDay();

}
