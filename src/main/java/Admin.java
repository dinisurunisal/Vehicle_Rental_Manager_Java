import com.mongodb.*;

import java.awt.*;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Scanner;

public class Admin {

    //MongoDb connection method
    static MongoClient mongo = new MongoClient( "localhost" , 27017 );
    static DB databasemongo = mongo.getDB("Westminster_Database");
    static DBCollection collectCar = databasemongo.getCollection("car_database");
    static DBCollection collectMotorbike = databasemongo.getCollection("motorbike_database");

    //creating an object of WestminsterRentalVehicleManager
    static WestminsterRentalVehicleManager adminOp = new WestminsterRentalVehicleManager();
    static Scanner input = new Scanner(System.in);

    static int countCar = (int) databasemongo.getCollection("car_database").count(); //count of documents in car database in Mongodb
    static int countMotorbike = (int) databasemongo.getCollection("motorbike_database").count(); //count of documents in motorbike database in Mongodb
    static int addition = countCar + countMotorbike;
    static int currentCount = 50-addition;
    static int recount = currentCount-1;


    public static void main(String[] args) {


        System.out.println("\n####  Welcome to Westminster Vehicle Store Manager  ####");
        System.out.println("\n**********************************************************");
        mainConsole();

    }

    private static void mainConsole(){
        int pick;
        do{
            System.out.println("\nTo proceed select Option: ");
            System.out.println("  1) Add a new vehicle");
            System.out.println("  2) Delete a vehicle");
            System.out.println("  3) Print the list of vehicle");
            System.out.println("  4) Write and Save ");
            System.out.println("  5) Open Customer GUI ");
            System.out.println("  6) Exit ");
            System.out.print(">");
            pick = intInputValidator();

            switch (pick) {
                case 1:
                    addVehicle();
                    break;

                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    listPrint();
                    break;
                case 4:
                    editAndSave();
                    break;
                case 5:
                    customerBook();
                    break;
                case 6:
                    System.out.println("Logged out from the System. Thank You.");
                    System.exit(0);

                default:
                    System.out.println("Invalid response!! Please Try Again.");

            }
        }while (pick < 1 || pick > 6);

    }

    private static int intInputValidator() {  //validating the integers from other types
        while (!input.hasNextInt()) {
            System.out.println("Invalid response!! Please Enter a numeric Value");
            System.out.print(">");
            input.next();
        }
        return input.nextInt();
    }

    private static BigDecimal bigDeciValidator() {  //validating the bigDecimal from other types
        while (!input.hasNextBigDecimal()) {
            System.out.println("Invalid response!! Please Enter a numeric Value");
            System.out.print(">");
            input.next();
        }
        return input.nextBigDecimal();
    }


    public static void addVehicle() {

        int typeOfVehicle;
        do{
            System.out.println("Enter the Type of the Vehicle:");
            System.out.println("  1.Car");
            System.out.println("  2.Motorbike");
            System.out.print(">");
            typeOfVehicle = intInputValidator();

        }while (typeOfVehicle<1 || typeOfVehicle>2);

        System.out.print("Enter vehicle Make: ");
        String vMake = input.next();

        System.out.print("Enter vehicle Model: ");
        String vModel = input.next();

        System.out.println("Enter vehicle Number-Plate: ");
        String vehiclePlateNumber ;
        vehiclePlateNumber = input.next();

        DBCollection collectCar1= databasemongo.getCollection("car_database");                //making the connection with the collection in Westminster_Database
        DBCollection collectTheMotorbike= databasemongo.getCollection("motorbike_database");  //making the connection with the collection in Westminster_Database
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("vehiclePlateNumber", vehiclePlateNumber);
        DBCursor cursor = collectCar1.find(searchQuery);
        DBCursor cursor1 = collectTheMotorbike.find(searchQuery);
        while (cursor.hasNext() || cursor1.hasNext()) {
            System.out.println("This Vehicle with plate number "+vehiclePlateNumber+  " already exists! ");
            System.out.println("Details of the existing vehicle:   " +cursor.next()  );
            System.out.println("\nPlease Re-enter >");
            vehiclePlateNumber = input.next();
        }
        vehiclePlateNumber = vehiclePlateNumber.toUpperCase();  //As Numberplate letters should be Upper camel case  //Referred from stack overflow
        

        int yearOfManufacture;
        System.out.print("Enter year of Manufacture: ");
        yearOfManufacture = intInputValidator();
        while((yearOfManufacture < 1990) || (yearOfManufacture > 2019)){ //Only years between 1990 and 2019 are allowed
            System.out.println("Invalid year!! Please input a valid year.");
            System.out.print(":");
            yearOfManufacture = intInputValidator();
        }

        System.out.print("Enter vehicle Color: ");
        String vehicleColor = input.next();

        int vSeatCapacity;
        System.out.print("Enter Number of Seats: ");
        vSeatCapacity = intInputValidator();
        if (typeOfVehicle==1) {
            while (vSeatCapacity < 2 || vSeatCapacity > 9) {  //Only seat capacity of 2 to 9 are allowed in car
                System.out.println("Invalid Number of seats!! Please input valid number of seats.");
                System.out.print(":");
                vSeatCapacity = intInputValidator();
            }
        }else{
            while (vSeatCapacity < 1 || vSeatCapacity > 3) {  //Only seat capacity of 1 to 3 are allowed in car
                System.out.println("Invalid Number of seats!! Please input valid number of seats.");
                System.out.print(":");
                vSeatCapacity = intInputValidator();
            }
        }

        int choose1;
        String vTransmission = null;
        System.out.println("\nSelect Transmission Type: ");  //Selecting an transmission from the given types
        System.out.println("  1)Automatic Transmission");
        System.out.println("  2)Manual Transmission");
        System.out.println("  3)Triptonic Transmission");
        System.out.println("  4)Other Transmission");
        do {
            System.out.print(":");
            choose1 = intInputValidator();
            if(choose1 == 1){
                vTransmission = "Automatic";
            }else if(choose1 == 2) {
                vTransmission = "Manual";
            }else if(choose1 == 3) {
                vTransmission = "Triptonic";
            }else if(choose1 == 4) {
                vTransmission = "Other";
            }else{
                System.out.println("Invalid response!! Please choose between 1 to 4.");
            }
        }while (choose1 < 1 || choose1 > 4);

        int choose2;
        String vFuelType = null;
        System.out.println("\nSelect Fuel Type: ");  //Selecting an fuel type from the given types
        System.out.println("  1)Diesel");
        System.out.println("  2)Petrol");
        System.out.println("  3)CNG");
        System.out.println("  4)Other");
        do {
            System.out.print(":");
            choose2 = intInputValidator();
            if(choose2 == 1){
                vFuelType = "Diesel";
            }else if(choose2 == 2) {
                vFuelType = "Petrol";
            }else if(choose2 == 3) {
                vFuelType = "CNG";
            }else if(choose2 == 4) {
                vFuelType = "Other";
            }else{
                System.out.println("Invalid response!! Please choose between 1 to 4.");
            }
        }while (choose2 < 1 || choose2 > 4);

        int vEngineCap;
        System.out.print("Enter Engine Capacity in CC: ");
        vEngineCap = intInputValidator();
        while (vEngineCap < 90 || vEngineCap > 6000) {  //Engine capacity vary from 90 to 6000 as least capacity in bikes are nearly 90 and max capacity in cars are 6000.
            System.out.println("Invalid Engine Capacity!! Please enter a valid engine capacity.");
            System.out.print(":");
            vEngineCap = intInputValidator();
        }

        System.out.print("Is the Vehicle Available Now (yes/no): ");  //Check whether the vehicle is available or not
        String available = input.next();
        boolean check = isAvailable(available);

        System.out.print("Enter the Rental Fee : ");  //The rental fee for a vehicle
        BigDecimal rentFee = bigDeciValidator();

        if (typeOfVehicle == 1) {  //After the attributes taken from the parent class, values get added according to the subclass
            String type= "Car";
            int noOfDoors;
            System.out.print("Enter the Number of Doors: ");  //The number of doors in a car
            noOfDoors = intInputValidator();
            while (noOfDoors < 2 || noOfDoors > 5) {
                System.out.println("Invalid number of doors!! Please enter valid number.");
                System.out.print(":");
                noOfDoors = intInputValidator();
            }

            System.out.print("AirCondition Available (yes/no): "); //checking the availability of Air Condition
            String acAvailable = input.next();
            boolean check1 = isAvailable(acAvailable);

            System.out.print("DVD Player Available (yes/no): "); //checking the availability of DVD player
            String dvdAvailable = input.next();
            boolean check2 = isAvailable(dvdAvailable);

            System.out.print("Spare Wheel Available (yes/no): "); //checking the availability of Spare wheel
            String swAvailable = input.next();
            boolean check3 = isAvailable(swAvailable);

            //Adding to the collection car_database in mongodb database
            DBCollection collectCar = databasemongo.getCollection("car_database");
            BasicDBObject input1 = new BasicDBObject("vehiclePlateNumber", vehiclePlateNumber)
                    .append("make", vMake)
                    .append("model", vModel)
                    .append("type", type)
                    .append("yearOfManufacture", yearOfManufacture)
                    .append("vehicleColor", vehicleColor)
                    .append("seatCapacity", vSeatCapacity)
                    .append("transmission", vTransmission)
                    .append("fuelType", vFuelType)
                    .append("engineCapacity", vEngineCap)
                    .append("availability", check)
                    .append("rentalFee", rentFee)
                    .append("noOfDoors", noOfDoors)
                    .append("airCondition", check1)
                    .append("dvdPlayer", check2)
                    .append("spareWheel", check3);
            collectCar.insert(input1);

            System.out.println("\nThe details of the car was added Successfully!!");

            Vehicle item = new Car(vMake,vModel,vehiclePlateNumber,yearOfManufacture,vehicleColor,vSeatCapacity,vTransmission,vFuelType,vEngineCap,check,rentFee,noOfDoors,check1,check2,check3);  //the following taken from music item
            adminOp.addVehicle(item);


        }else{
            String type = "Motorbike";

            System.out.print("Helmet Available (yes/no): ");  //Helmet availability of the motorbike
            String hAvailable = input.next();
            boolean check4 = isAvailable(hAvailable);

            System.out.print("TrunkCase Available (yes/no): ");  //TrunkCase availability of the motorbike
            String tcAvailable = input.next();
            boolean check5 = isAvailable(tcAvailable);

            System.out.print("Bike Jacket Available (yes/no): ");  //Bike Jacket availability of the motorbike
            String bjAvailable = input.next();
            boolean check6 = isAvailable(bjAvailable);

            //Adding to the collection motorbike_database in mongodb database
            DBCollection collectMotorbike = databasemongo.getCollection("motorbike_database");
            BasicDBObject input1 = new BasicDBObject("vehiclePlateNumber", vehiclePlateNumber)
                    .append("make", vMake)
                    .append("model", vModel)
                    .append("type", type)
                    .append("yearOfManufacture", yearOfManufacture)
                    .append("vehicleColor", vehicleColor)
                    .append("seatCapacity", vSeatCapacity)
                    .append("transmission", vTransmission)
                    .append("fuelType", vFuelType)
                    .append("engineCapacity", vEngineCap)
                    .append("availability", check)
                    .append("rentalFee", rentFee)
                    .append("helmetAvailability", check4)
                    .append("bikeTrunkCaseAvailability", check5)
                    .append("bikeJacketAvailability", check6);
            collectMotorbike.insert(input1);

            System.out.println("\nThe details of the motorbike was added Successfully!!");

            Vehicle item = new Motorbike(vMake,vModel,vehiclePlateNumber,yearOfManufacture,vehicleColor,vSeatCapacity,vTransmission,vFuelType,vEngineCap,check,rentFee,check4,check5,check6);  //the following taken from music item
            adminOp.addVehicle(item);

        }
        mainConsole();

    }

    private static void deleteVehicle(){
        System.out.println("Enter the Vehicle Number-Plate (*Please enter in capital letters*) : ");
        String vehiclePlateNumber = input.next();

        for(Vehicle vehicleDet : adminOp.getStoreVehicle()){                    //Enhanced for loop is used to iterate through each element in arrayList
            if(vehicleDet.getVehiclePlateNumber().equals(vehiclePlateNumber)){
                adminOp.deleteVehicle(vehicleDet);                              //directing to the delete vehicle method in westminsterRentalManager
                System.out.println("\nVehicle was Deleted from the System!!");
                BasicDBObject deleteV = new BasicDBObject();
                deleteV.put("vehiclePlateNumber", vehiclePlateNumber);
                collectCar.remove(deleteV);
                collectMotorbike.remove(deleteV);


                System.out.println("\nNumber of available parking lots in the garage : " + currentCount +" parking lots");  //Getting the number of available parking lots from the database

                mainConsole();

            }else{
                System.out.println("Vehicle is not found in the system!!");

                System.out.println("\nNumber of available parking lots in the garage : " + recount  +" parking lots");  //Getting the number of available parking lots from the database
                mainConsole();
            }
        }mainConsole();
    }

    private static void listPrint(){


        adminOp.printList(); //Printing the list of currently inputed values
        mainConsole();

    }

    private static void editAndSave(){
        adminOp.editAndSave();  //File handling where the data is written to a file name VehicleList.txt
        System.out.println("Successfully written to VehicleList.txt ");
        mainConsole();
    }

    private static void customerBook(){
        try {
            Desktop show = java.awt.Desktop.getDesktop();  //This method is used to open the angular GUI from the managers perspective
            URI urlShow = new URI("http://localhost:4200/");  //Referred from https://www.programcreek.com/java-api-examples/java.awt.Desktop
            show.browse(urlShow);                                  //Referred from https://www.codota.com/code/java/methods/java.awt.Desktop/getDesktop
            mainConsole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean isAvailable(String answer){  //Input yes is taken as true and no is taken as false
        if(answer.equals("yes")){
            return true;
        }return false;
    }



}



 /*       for(Vehicle item : adminOp.getStoreVehicle()){
            if(item.getVehiclePlateNumber().equals(vehiclePlateNumber)){         //Check whether vehicle plate Number exists
                System.out.println("Vehicle plate number exits already!!");
            }else {
                continue;
            }
        }*/
 
 /*        DBCollection deleteTheCar= databasemongo.getCollection("car_database") ;
        DBCollection deleteTheMotorbike= databasemongo.getCollection("motorbike_database") ;
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("vehiclePlateNumber", vehiclePlateNumber);
        DBCursor cursor = deleteTheCar.find(searchQuery);
        DBCursor cursor1 = deleteTheMotorbike.find(searchQuery);
        if (cursor.hasNext() || cursor1.hasNext()) {
            System.out.println("This Vehicle with plate number "+vehiclePlateNumber+  " was deleted successfully! ");
            System.out.println("Details of the existing vehicle:   " +cursor.next()  );
            deleteTheCar.remove(cursor.next());
            deleteTheMotorbike.remove(cursor1.next());
        }*/
