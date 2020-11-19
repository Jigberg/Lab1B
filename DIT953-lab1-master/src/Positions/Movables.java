package Positions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Movables extends Positionables {
    private double currentSpeed; // The current speed
    private boolean isMovable; // Used to know if it is in a movable state
    private double maxSpeed;
    private final List<Direction> directionList = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    public Movables(int xPos, int yPos, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed) {
        super(xPos, yPos, direction);
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
                case Direction.NORTH -> setyPos(getyPos() + getCurrentSpeed());
                case Direction.EAST -> setxPos(getxPos() + getCurrentSpeed());
                case Direction.SOUTH -> setyPos(getyPos() - getCurrentSpeed());
                case Direction.WEST -> setxPos(getxPos() - getCurrentSpeed());
                default -> System.out.print("non valid direction!");
            }
        }
    }

    /**
     * Turns the car left.
     */
    public void turnLeft() {
        Collections.rotate(getDirectionList(), 1);
    }

    /**
     * Turns the car right.
     */
    public void turnRight() {
        Collections.rotate(getDirectionList(), -1);
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    double getMaxSpeed(){ return this.maxSpeed; }

    /**
     * Decrements the speed a specified amount.
     * Checks if current speed is in interval [0, enginePower]
     * @param currentSpeed The speed that the car already has.
     */
    void setCurrentSpeed(double currentSpeed) {
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

    boolean getIsMovable() {
        return isMovable;
    }

    void setIsMovable(boolean drivable) {
        isMovable = drivable;
    }

    List<Direction> getDirectionList(){
        return directionList;
    }


}
