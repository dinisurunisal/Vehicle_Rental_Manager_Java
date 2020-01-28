import java.math.BigDecimal;
import java.util.Objects;

public class Car extends Vehicle {

    private int noOfDoors;
    private boolean airCondition;
    private boolean dvdPlayer;
    private boolean spareWheel;

    public Car(String make, String model, String vehiclePlateNumber, int yearOfManufacture, String vehicleColor, int seatCapacity, String transmission, String fuelType, int engineCapacity, boolean availability, BigDecimal rentalFee, int noOfDoors, boolean airCondition, boolean dvdPlayer, boolean spareWheel) {
        super(make, model, vehiclePlateNumber, yearOfManufacture, vehicleColor, seatCapacity, transmission, fuelType, engineCapacity, availability, rentalFee);
        this.noOfDoors = noOfDoors;
        this.airCondition = airCondition;
        this.dvdPlayer = dvdPlayer;
        this.spareWheel = spareWheel;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isDvdPlayer() {
        return dvdPlayer;
    }

    public void setDvdPlayer(boolean dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public boolean isSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(boolean spareWheel) {
        this.spareWheel = spareWheel;
    }

    @Override
    public String toString() {
        return "\n > Type = Car" +
                ", Make ='" + make + '\'' +
                ", Model ='" + model + '\'' +
                ", Plate Number ='" + vehiclePlateNumber + '\'' +
                ", Year Of Manufacture =" + yearOfManufacture +
                ", Color ='" + vehicleColor + '\'' +
                ", Seat Capacity =" + seatCapacity +
                ", Transmission ='" + transmission + '\'' +
                ", Fuel Type ='" + fuelType + '\'' +
                ", Engine Capacity ='" + engineCapacity + '\'' +
                ", Availability =" + availability +
                ", Rental Fee =" + rentalFee +
                ", No Of Doors =" + noOfDoors +
                ", Air Condition =" + airCondition +
                ", Dvd Player =" + dvdPlayer +
                ", SpareWheel =" + spareWheel +
        '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return noOfDoors == car.noOfDoors &&
                airCondition == car.airCondition &&
                dvdPlayer == car.dvdPlayer &&
                spareWheel == car.spareWheel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), noOfDoors, airCondition, dvdPlayer, spareWheel);
    }
}
