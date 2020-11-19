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
    private double trimFactor;

    /**
     * Constructor for class.
     */
    public Volvo240(double x, double y, Direction direction, double currentSpeed, boolean isMovable, Color color, double trimFactor) {
        super(x, y, direction, currentSpeed, isMovable, 200, color, "Volvo240");
        this.trimFactor = trimFactor;
    }
    /**
     * Calculates the speedfactor.
     * Uses trimFactor.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }




}
