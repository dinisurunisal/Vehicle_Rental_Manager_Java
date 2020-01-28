import java.math.BigDecimal;
import java.util.Objects;

abstract public class Vehicle {
    protected String make;
    protected String model;
    protected String vehiclePlateNumber;
    protected int yearOfManufacture;
    protected String vehicleColor;
    protected int seatCapacity;
    protected String transmission;
    protected String fuelType;
    protected int engineCapacity;
    protected boolean availability;
    protected BigDecimal rentalFee;

    public Vehicle(String make, String model, String vehiclePlateNumber, int yearOfManufacture, String vehicleColor, int seatCapacity, String transmission, String fuelType, int engineCapacity, boolean availability, BigDecimal rentalFee) {
        this.make = make;
        this.model = model;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleColor = vehicleColor;
        this.seatCapacity = seatCapacity;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.availability = availability;
        this.rentalFee = rentalFee;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public BigDecimal getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(BigDecimal rentalFee) {
        this.rentalFee = rentalFee;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", availability=" + availability +
                ", rentalFee=" + rentalFee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return yearOfManufacture == vehicle.yearOfManufacture &&
                seatCapacity == vehicle.seatCapacity &&
                availability == vehicle.availability &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(vehiclePlateNumber, vehicle.vehiclePlateNumber) &&
                Objects.equals(vehicleColor, vehicle.vehicleColor) &&
                Objects.equals(transmission, vehicle.transmission) &&
                Objects.equals(fuelType, vehicle.fuelType) &&
                Objects.equals(engineCapacity, vehicle.engineCapacity) &&
                Objects.equals(rentalFee, vehicle.rentalFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, vehiclePlateNumber, yearOfManufacture, vehicleColor, seatCapacity, transmission, fuelType, engineCapacity, availability, rentalFee);
    }


    public int compareTo(Vehicle o) {
        return make.compareTo(o.getMake());
    }
}
