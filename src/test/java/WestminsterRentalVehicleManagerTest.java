import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class WestminsterRentalVehicleManagerTest implements RentalVehicleManagerTest{

    private List<Vehicle> storeVehicleDetailsTest = new ArrayList<Vehicle>(); //Because to solve the ConcurrentModificationException
    private static final int MAX_PARKING_TEST = 50;
    private static int countTest = 0;

    public List<Vehicle> getStoreVehicleTest() {
        return storeVehicleDetailsTest;
    }

    @Override
    public void addVehicleTest(Vehicle vehicleDet) {
        if (storeVehicleDetailsTest.size() < MAX_PARKING_TEST){
            storeVehicleDetailsTest.add(vehicleDet);
        }else {
            System.out.println("Car Park is full !");
        }
    }

    @Override
    public boolean deleteVehicleTest(Vehicle vehicleDet) {
        System.out.print("Details of the vehicle deleted :");
        System.out.println(vehicleDet);
        return storeVehicleDetailsTest.remove(vehicleDet);
    }

    @Override
    public List printListTest() {

        Collections.sort(storeVehicleDetailsTest, new MakeComparatorTest());
        System.out.println(storeVehicleDetailsTest);
        return storeVehicleDetailsTest;
    }

    @Override
    public void editAndSaveTest() {
        File file = new File("VehicleListTest.txt");
        FileWriter flw = null;
        try {
            flw = new FileWriter(file, true);
            flw.write(String.valueOf(storeVehicleDetailsTest));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                flw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class MakeComparatorTest implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getMake().compareTo(o2.getMake());
    }
}