package Positions;

import java.util.Arrays;
import java.util.List;

public abstract class Movables extends Positionables {
    private double currentSpeed; // The current speed
    private boolean isMovable; // Used to know if it is in a movable state
    private double maxSpeed;
    private final List<Direction> directionList = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public Movables(int x, int y, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed) {
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
    double getMaxSpeed(){ return this.maxSpeed; }

    /**
     * Decrements the speed a specified amount.
     * Checks if current speed is in interval [0, enginePower]
     * @param currentSpeed The speed that the car already has.
     */
    protected void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed >= 0 && currentSpeed <=getMaxSpeed()){
            this.currentSpeed = currentSpeed;
        }
        else if(currentSpeed < 0){
            this.currentSpeed = 0;
        }
        else{
            this.currentSpeed = getMaxSpeed();
        }

    }

    /**
     * Increments the speed a specified amount.
     * @param amount to increment the speed.
     */
    abstract void incrementSpeed(double amount);

    /**
     * Decrements the speed a specified amount.
     * @param amount to decrement the speed.
     */
    abstract void decrementSpeed(double amount);

    protected boolean getIsMovable() {
        return isMovable;
    }

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
