package Vehicles;
import java.awt.*;
import Positions.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public abstract class Vehicle extends Movables {
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    /**
     * Constructor for the class Car.
     * Stops the car.
     * @param enginePower engine power of the car.
     * @param color color of the car.
     * @param modelName the cars model name.
     */
    public Vehicle(double x, double y, Direction direction,
                   double currentSpeed, boolean isMovable,
                   double enginePower, Color color, String modelName) {
        super(x, y, direction, currentSpeed, isMovable, enginePower);
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
    }
    /**
     * Stops the car engine.
     */
    void stopEngine() {
        setCurrentSpeed(0);
    }
    /**
     * Starts the car engine.
     */
    void startEngine() {
        setCurrentSpeed(0.1);
    }
    public double speedFactor(){ return 0.01; }
    @Override
    public double calculateSpeedChange(double amount){ return getCurrentSpeed() + amount * speedFactor(); }
    @Override
    public boolean isSpeedChangeInRange(double amount){ return -1.0 < amount && amount < 1.0; }
    public void gas(double amount) { changeSpeed(amount); }
    public void brake(double amount) { changeSpeed(-amount); }
    public double getEnginePower() { return enginePower; }
}
