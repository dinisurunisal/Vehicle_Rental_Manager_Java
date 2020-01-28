import java.math.BigDecimal;
import java.util.Objects;

public class Motorbike extends Vehicle{
    private boolean helmetAvailability;
    private boolean bikeTrunkCaseAvailability;
    private boolean bikeJacketAvailability;

    public Motorbike(String make, String model, String vehiclePlateNumber, int yearOfManufacture, String vehicleColor, int seatCapacity, String transmission, String fuelType, int engineCapacity, boolean availability, BigDecimal rentalFee, boolean helmetAvailability, boolean bikeTrunkCaseAvailability, boolean bikeJacketAvailability) {
        super(make, model, vehiclePlateNumber, yearOfManufacture, vehicleColor, seatCapacity, transmission, fuelType, engineCapacity, availability, rentalFee);
        this.helmetAvailability = helmetAvailability;
        this.bikeTrunkCaseAvailability = bikeTrunkCaseAvailability;
        this.bikeJacketAvailability = bikeJacketAvailability;
    }

    public boolean isHelmetAvailability() {
        return helmetAvailability;
    }

    public void setHelmetAvailability(boolean helmetAvailability) {
        this.helmetAvailability = helmetAvailability;
    }

    public boolean isBikeTrunkCaseAvailability() {
        return bikeTrunkCaseAvailability;
    }

    public void setBikeTrunkCaseAvailability(boolean bikeTrunkCaseAvailability) {
        this.bikeTrunkCaseAvailability = bikeTrunkCaseAvailability;
    }

    public boolean isBikeJacketAvailability() {
        return bikeJacketAvailability;
    }

    public void setBikeJacketAvailability(boolean bikeJacketAvailability) {
        this.bikeJacketAvailability = bikeJacketAvailability;
    }

    @Override
    public String toString() {
        return "\n > Type = Motorbike" +
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
                ", Helmet Availability =" + helmetAvailability +
                ", Bike TrunkCase Availability =" + bikeTrunkCaseAvailability +
                ", Bike Jacket Availability =" + bikeJacketAvailability +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorbike motorbike = (Motorbike) o;
        return helmetAvailability == motorbike.helmetAvailability &&
                bikeTrunkCaseAvailability == motorbike.bikeTrunkCaseAvailability &&
                bikeJacketAvailability == motorbike.bikeJacketAvailability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), helmetAvailability, bikeTrunkCaseAvailability, bikeJacketAvailability);
    }
}
