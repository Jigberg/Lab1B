package Vehicles;

import java.awt.*;
import DumbAssKangarooPackage.Direction;

/**
 * @author Lukas, Emil, Martin.
 * A class for truck Vehicles.Scania
 */

public class Scania extends Vehicle {
    private double rampAngle;

    public Scania(int xPos, int yPos, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed, double enginePower, Color color, String modelName) {
        super(xPos, yPos, direction.NORTH, 0, true, 100, Color.DARK_GRAY, "Vehicles.Scania");
    }

    /**
     * Lowers platform.
     * @param angle to lower platform.
     */
    @Override
    void lowerRamp(int angle) {
        if (getCurrentSpeed() == 0) {
            setRampAngle(Math.max(getRampAngle() - angle, 0));
        } else {
            System.out.println("Can't lower ramp while moving");
        }
    }

    /**
     * Raises platform.
     * @param angle to raise platform.
     */
    @Override
    void raiseRamp(int angle){
        if (getCurrentSpeed() == 0){
            setRampAngle(Math.min(getRampAngle() + angle, 70));
        }else{
            System.out.println("Can't raise ramp while moving");
        }
    }

    public double getRampAngle(){
        return rampAngle;
    }

    public void setRampAngle(double angle){
        this.rampAngle = angle;
    }
}

