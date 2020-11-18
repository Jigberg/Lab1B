package Carriers;
import java.util.ArrayList;
import Vehicles.Vehicle;

public class FerryCarrier extends Carrier<Vehicle>{
    public FerryCarrier(){
        super(20, new ArrayList<>());
    }
}
