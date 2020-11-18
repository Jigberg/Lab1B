package Carriers;

import DumbAssKangarooPackage.Workshop;
import Positions.Movables;

import java.util.ArrayList;


public class WorkshopCarrier<T extends Movables> extends Carrier<T, Workshop<T>>{
    public WorkshopCarrier(Workshop<T> attachedTo){
        super(8, new ArrayList<>(), attachedTo);
    }

    T unload(T t){
        getLoad().remove(t);
        t.setIsMovable(true);
        return t;
    }

    @Override
    void unload() {}

    @Override
    void load(T t) {
        if(isLoadable(t)){
            getLoad().add(t);
        }

    }

    @Override
    boolean isLoadable(T loadType) { return getVolume() != getCapacity(); }


}
