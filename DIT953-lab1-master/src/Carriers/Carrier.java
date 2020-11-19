package Carriers;
import java.util.List;

public abstract class Carrier<T, A>{
    private int capacity;
    private List<T> load;
    private T loadType;
    private A attachedTo;

    public Carrier(int capacity, List<T> load, A attachedTo){
        this.capacity = capacity;
        this.load = load;
        this.attachedTo = attachedTo;
    }

    abstract void unload();
    abstract void load(T loadType);
    abstract boolean isLoadable(T loadType);

    public List<T> getLoad(){ return this.load; }
    int getCapacity(){ return this.capacity; }
    int getVolume(){ return load.size(); }
    public T getLoadType() { return loadType; }
    public A getAttachedTo(){ return this.attachedTo; }

}