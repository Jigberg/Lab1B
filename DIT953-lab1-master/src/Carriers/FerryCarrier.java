package Carriers;
import java.util.ArrayList;

import Vehicles.Ferry;
import Vehicles.Vehicle;

public class FerryCarrier extends Carrier<IFerryCarrier, Ferry>{
    public FerryCarrier(Ferry attachedTo){
        super(20, new ArrayList<>(), attachedTo);
    }

    @Override
    void unload() {

    }

    @Override
    void load(IFerryCarrier loadType) {

    }

    @Override
    boolean isLoadable(IFerryCarrier loadType) {
        return false;
    }
}
