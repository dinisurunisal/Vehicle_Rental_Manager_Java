import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WestminsterRentalVehicleManager implements RentalVehicleManager{

    private List<Vehicle> storeVehicleDetails = new CopyOnWriteArrayList<Vehicle>(); //CopyOnWriteArrayList to solve the ConcurrentModificationException
    private static final int MAX_PARKING = 50;
    private static int count = 0;

    public List<Vehicle> getStoreVehicle() {
        return storeVehicleDetails;
    }

    @Override
    public void addVehicle(Vehicle vehicleDet) {        //Overriden addVehicle of RentalVehicleManger Interface
        if (storeVehicleDetails.size() < MAX_PARKING){  //validation for finding whether parking size is lower than 50
            storeVehicleDetails.add(vehicleDet);
        }else {
            System.out.println("Car Park is full !");
        }
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicleDet) {      //Overriden addVehicle of RentalVehicleManger Interface
        System.out.print("Details of the vehicle deleted :");
        System.out.println(vehicleDet);
        return storeVehicleDetails.remove(vehicleDet);  ///Removed from the storeVehicleDetails arrayList
    }

    @Override
    public void printList() {

        Collections.sort(storeVehicleDetails, new MakeComparator());  //the data sets are sorted by their make
        System.out.println(storeVehicleDetails);
    }

    @Override
    public void editAndSave() {             //File handling used to write to a file
        File file = new File("VehicleList.txt");
        FileWriter flw = null;
        try {
            flw = new FileWriter(file, true);
            flw.write(String.valueOf(storeVehicleDetails));
        } catch (IOException e) {
            e.printStackTrace();  //method of class throwable
        }finally {
            try{
                flw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class MakeComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {  //Comparator used for sorting and comparing by make
        return o1.getMake().compareTo(o2.getMake());
    }
}