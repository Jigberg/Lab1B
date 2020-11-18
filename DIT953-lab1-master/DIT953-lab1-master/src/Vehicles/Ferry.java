package Vehicles;

import Carriers.Carrier;
import Carriers.FerryCarrier;

public class Ferry extends Vehicle {
    private Carrier<Vehicle> carrier = new FerryCarrier();

}
