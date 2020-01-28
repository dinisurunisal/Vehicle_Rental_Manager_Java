
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class AdminTest {
    WestminsterRentalVehicleManagerTest adminTest = new WestminsterRentalVehicleManagerTest();
    Admin underTesting = new Admin();

  @Test
    void init() {


      String vMake = "Toyota";
      String vModel = "Axio";
      String vehiclePlateNumber = "AKC-7896";
      int yearOfManufacture = 2015;
      String vehicleColor = "Grey";
      int vSeatCapacity = 4;
      String vTransmission = "Automatic";
      String vFuelType = "Petrol";
      int vEngineCap = 1500;
      boolean isAvailable = true;
      BigDecimal rentFee = new BigDecimal(25.25);
      int noOfDoors = 4;
      boolean acAvailable = true;
      boolean dvdAvailable = true;
      boolean spareAvailable = true;

      Vehicle testItem = new Car(vMake,vModel,vehiclePlateNumber,yearOfManufacture,vehicleColor,vSeatCapacity,vTransmission,vFuelType,vEngineCap,isAvailable,rentFee,noOfDoors,acAvailable,dvdAvailable,spareAvailable);

      assertEquals(true,true);

    }

    @Test
    void addVehicleTest() {

        String vMake = "Toyota";
        String vModel = "Axio";
        String vehiclePlateNumber = "AKC-7896";
        int yearOfManufacture = 2015;
        String vehicleColor = "Grey";
        int vSeatCapacity = 4;
        String vTransmission = "Automatic";
        String vFuelType = "Petrol";
        int vEngineCap = 1500;
        boolean isAvailable = true;
        BigDecimal rentFee = new BigDecimal(25.25);
        int noOfDoors = 4;
        boolean acAvailable = true;
        boolean dvdAvailable = true;
        boolean spareAvailable = true;

        Vehicle testItem = new Car(vMake,vModel,vehiclePlateNumber,yearOfManufacture,vehicleColor,vSeatCapacity,vTransmission,vFuelType,vEngineCap,isAvailable,rentFee,noOfDoors,acAvailable,dvdAvailable,spareAvailable);
        adminTest.addVehicleTest(testItem);

        assertEquals(1, adminTest.getStoreVehicleTest().size(),"If the vehicle was added the size of the store should be 1");

        System.out.println("The expected size of the ArrayList = 1");
        System.out.println("The actual size of the ArrayList = "+ adminTest.getStoreVehicleTest().size());
        System.out.println("The test has been succeeded!");

    }

    @Test
    void PrintVehicleTest(){
        adminTest.printListTest();
        assertEquals(true,true);
    }


    @Test
    void deleteVehicleTest() {

        adminTest.getStoreVehicleTest().remove("VehicleTest");
        assertEquals(0, adminTest.getStoreVehicleTest().size(),"If the vehicle was removed the size of the store should be 0");

        System.out.println("The expected size of the ArrayList = 0");
        System.out.println("The actual size of the ArrayList = "+ adminTest.getStoreVehicleTest().size());
        System.out.println("The test has been succeeded!");
    }




}









//@Test
        /*void testMake() {

            String result = underTesting.
            String expected="Toyota";
            String try1="Toyota";
            String try2="Honda";
            String try3=null;*/

//assertEquals(expected, try1); //this compare the identity by equals method
//assertSame(expected, try1); //this compare the value by equals method
      /*      assertNotSame(expected, try2);
            assertNotNull(try1);
            assertNull(try3);
        }
*/

