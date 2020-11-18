package Vehicles;
import DumbAssKangarooPackage.*;
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
    public Vehicle(int xPos, int yPos, Direction direction,
                   double currentSpeed, boolean isMovable,
                   double enginePower, Color color, String modelName) {
        super(xPos, yPos, direction, currentSpeed, isMovable, enginePower);
        this.color = color;
        this.modelName = modelName;
        stopEngine();
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

    /**
     *
     * @return a calculated speedFactor.
     */
    double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Increments the speed a specified amount.
     * @param amount to multiply the speedfactor with.
     */

    void gas(double amount) {
        if (amount >= 0 && amount <= 1.0){
            incrementSpeed(amount);
        }
        else{
            System.out.println("Not valid amount.");
        }
    }

    /**
     * Decrements the speed a specified amount.
     * @param amount to multiply the speedfactor with.
     */

    void brake(double amount) {
        if (amount >= 0 && amount <= 1.0){
            decrementSpeed(amount);
        }
        else{
            System.out.println("Not valid amount.");
        }
    }

    /**
     * Increments the speed.
     * @param amount to multiply the speedFactor with.
     */
    @Override
    void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + amount*speedFactor());
    }

    /**
     * Decrements the speed.
     * @param amount to multiply the speedFactor with.
     */
    @Override
    void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - amount*speedFactor());
    }


    // ----------- getters and setters -----------

    double getEnginePower() {
        return enginePower;
    }

}
