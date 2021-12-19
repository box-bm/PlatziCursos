package Java;

public class Car {
    Integer id;
    String license;
    Account driver;
    private Integer passenger;

    public Car(String license, Account driver) {
        this.license = license;
        this.driver = driver;
    }

    void printDataCar() {
        System.out.println("License: " + license + " Driver: " + driver.name + " Passenger: " + passenger);
    }

    public Integer getPassenger() {
        return passenger;
    }

    public void setPassenger(Integer passenger) {
        if (passenger <= 4) {
            this.passenger = passenger;
        } else {
            System.out.println("The passenger must be 4");
        }
    }

}
