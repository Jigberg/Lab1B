package DumbAssKangarooPackage;

import Carriers.Carrier;
import Carriers.WorkshopCarrier;
import Positions.Movables;
import Vehicles.Vehicle;

import java.util.*;

public class Workshop<T extends Movables> {
    Carrier<T, Workshop<T>> carrier = new WorkshopCarrier<T>(this);

    public Carrier<T, Workshop<T>> getCarrier(){ return this.carrier; }
}