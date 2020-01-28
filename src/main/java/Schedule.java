import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Date;

public class Schedule {
    private Date vehiclePickUpDate;
    private Date vehicleDropOffDate;


    Date date = new Date();

    public Schedule(Date vehiclePickUpDate, Date vehicleDropOffDate) {
        this.vehiclePickUpDate = vehiclePickUpDate;
        this.vehicleDropOffDate = vehicleDropOffDate;
    }

    public Date getVehiclePickUpDate() {
        return vehiclePickUpDate;
    }

    public void setVehiclePickUpDate(Date vehiclePickUpDate) {
        this.vehiclePickUpDate = vehiclePickUpDate;
    }

    public Date getVehicleDropOffDate() {
        return vehicleDropOffDate;
    }

    public void setVehicleDropOffDate(Date vehicleDropOffDate) {
        this.vehicleDropOffDate = vehicleDropOffDate;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "vehiclePickUpDate=" + vehiclePickUpDate +
                ", vehicleDropOffDate=" + vehicleDropOffDate +
                '}';
    }


    DBCollection customerBookData= Admin.databasemongo.getCollection("bookCust_database");
    private static void selectPickUp(DBCollection customerBookData)
    {
        BasicDBObject query11 = new BasicDBObject();
        BasicDBObject formField = new BasicDBObject();
        formField.put("pickup", 1);
        DBCursor cursor = Admin.databasemongo.getCollection("bookCust_database").find(query11,formField);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
