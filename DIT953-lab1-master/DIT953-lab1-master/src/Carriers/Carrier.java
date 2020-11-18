package Carriers;

import java.util.List;

public abstract class Carrier<T> {
    private int capacity;
    private List<T> load;

    public Carrier(int capacity, List<T> load){
        this.capacity = capacity;
        this.load = load;
    }


    abstract void unload();
    abstract void load(T loadType);
    abstract boolean isLoadable(T loadType);

    List<T> getLoad(){ return this.load; }
    int getCapacity(){ return this.capacity; }
    int getVolume(){ return load.size(); }
}