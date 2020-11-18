package Vehicles;

import Carriers.ICarTransportCarrier;
import Carriers.IFerryCarrier;
import Positions.Direction;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240 extends Vehicle implements ICarTransportCarrier, IFerryCarrier{
    private final static double trimFactor = 1.25;

    /**
     * Constructor for class.
     */
    public Volvo240(double x, double y, Direction direction, double currentSpeed, boolean isMovable, Color color) {
        super(x, y, direction, currentSpeed, isMovable, 200, color, "Volvo240");
    }

     boolean isDrivable(){
        return true;
    }

    /**
     * Calculates the speedfactor.
     * Uses trimFactor.
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increments the cars speed.
     * @param amount to multiply the speedfactor with.
     */
    @Override
    void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the cars speed.
     * @param amount to multiply the speedfactor with.
     */
    @Override
    void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }

}
