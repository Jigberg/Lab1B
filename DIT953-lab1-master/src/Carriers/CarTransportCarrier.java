package Carriers;
import Positions.Movables;
import Positions.Positionables;
import Vehicles.Car_Transport;
import Vehicles.Vehicle;
import java.util.ArrayList;

public class CarTransportCarrier extends Carrier<ICarTransportCarrier, Car_Transport> {
    public CarTransportCarrier(Car_Transport attachedTo) {
        super(6, new ArrayList<>(), attachedTo);
    }

    /**
     * checks if the loading car is in range.
     *
     * @param loadingCar that is being loaded.
     * @return true if in range.
     */
    boolean isRightPosition(ICarTransportCarrier loadingCar){
        switch (((Positionables) loadingCar).getDirection()) {
            case NORTH:
                if (((Positionables) loadingCar).getx() < getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < 3) && Math.abs(getAttachedTo().getx() - ((Positionables) loadingCar).getx()) < 0.001) {
                    return true;
                }
            case EAST:
                if (((Positionables) loadingCar).getx() < getAttachedTo().getx() && (getAttachedTo().getx() - ((Positionables) loadingCar).getx() < 3) && Math.abs(getAttachedTo().gety() - ((Positionables) loadingCar).gety()) < 0.001) {
                    return true;
                }
            case SOUTH:
                if (((Positionables) loadingCar).gety() > getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < -3) && Math.abs(getAttachedTo().getx() - ((Positionables) loadingCar).getx()) > -0.001) {
                    return true;
                }
            case WEST:
                if (((Positionables) loadingCar).getx() > getAttachedTo().getx() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < -3) && Math.abs(getAttachedTo().gety() - ((Positionables) loadingCar).gety()) < 0.001) {
                    return true;
                }
            default:
                System.out.print("not right position");
                return false;
        }
    }

    @Override
    void unload() {

    }

    @Override
    void load(ICarTransportCarrier loadType) {

    }

    /**
     * Checks if car can be loaded onto Vehicles.getAttachedTo().
     *
     * @param load that is being loaded.
     * @return true if car is loadable.
     */
    public boolean isLoadable(ICarTransportCarrier load) {
        if (getAttachedTo().getDirection() != ((Movables) load).getDirection()) { return false; }
        if (getAttachedTo().getRamp().getAngle() != 0) { return false; }
        if (getLoad().size() == getCapacity()) { return false; }
        if (((Vehicle) load).getCurrentSpeed() != 0 || getAttachedTo().getCurrentSpeed() != 0) { return false; }
        if (!isRightPosition(load)) { return false; }
        return true;
    }
}
