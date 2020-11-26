package Vehicles;

import Carriers.ICarTransportCarrier;
import Carriers.IFerryCarrier;
import Positions.Direction;
import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Saab95
 */
public class Saab95 extends Vehicle implements ICarTransportCarrier, IFerryCarrier {
    private boolean turboOn;
    private double turboValue;

    /**
     * Constructor for class.
     * Turns turbo off.
     */
    public Saab95(double x, double y, Direction direction, double currentSpeed, boolean isMovable, Color color, boolean turboOn, double turboValue) {
        super(x, y, direction, currentSpeed, isMovable, 150, color, "Saab95");
        this.turboOn = turboOn;
        this.turboValue = turboValue;
    }
    /**
     * Turns the turbo on.
     */
    void setTurboOn(boolean turboOn) { this.turboOn = turboOn; }
    /**
     * Calculates the speedFactor.
     * Uses turbo.
     */
    @Override
    public double speedFactor() { return getEnginePower() * 0.01 * (getTurboOn() ? getTurboValue() : 1); }
    public boolean getTurboOn(){ return this.turboOn; }
    public double getTurboValue(){ return this.turboValue; }

}
