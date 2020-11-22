package Positions;

import java.util.Arrays;
import java.util.List;

public abstract class Movables extends Positionables {
    private double currentSpeed; // The current speed
    private boolean isMovable; // Used to know if it is in a movable state
    private double maxSpeed;
    private final List<Direction> directionList = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public Movables(double x, double y, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed) {
        super(x, y, direction);
        this.currentSpeed = currentSpeed;
        this.isMovable = isMovable;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Moves the car depending on direction.
     */
    public void move() {
        if(getIsMovable()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getCurrentSpeed());
                case EAST -> setx(getx() + getCurrentSpeed());
                case SOUTH -> sety(gety() - getCurrentSpeed());
                case WEST -> setx(getx() - getCurrentSpeed());
            }
        }
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public double getMaxSpeed(){ return this.maxSpeed; }
    /**
     * Decrements the speed a specified amount.
     * Checks if current speed is in interval [0, enginePower]
     * @param currentSpeed The speed that the car already has.
     */
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }
    public void changeSpeed(double amount){
        if(!isSpeedChangeInRange(amount)){amount = setSpeedChangeInRange(amount); }
        setCurrentSpeed(calculateSpeedChange(amount));
    }
    public double calculateSpeedChange(double amount){ return getCurrentSpeed() + amount; }
    public double setSpeedChangeInRange(double amount){return getCurrentSpeed() + amount < 0 ? -getCurrentSpeed() : getMaxSpeed() - getCurrentSpeed(); }
    public boolean isSpeedChangeInRange(double amount){ return (0 <= getCurrentSpeed() + amount && getCurrentSpeed() + amount < getMaxSpeed()); }
    public boolean getIsMovable() { return isMovable; }
    public void setIsMovable(boolean isMovable) { this.isMovable = isMovable; }
    /**
     * Turns the car left.
     */
    public void turnLeft() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.WEST);
            case EAST -> setDirection(Direction.NORTH);
            case SOUTH -> setDirection(Direction.EAST);
            case WEST -> setDirection(Direction.SOUTH);
        }
    }
    /**
     * Turns the car right.
     */
    public void turnRight() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.EAST);
            case EAST -> setDirection(Direction.SOUTH);
            case SOUTH -> setDirection(Direction.WEST);
            case WEST -> setDirection(Direction.NORTH);
        }
    }
}
