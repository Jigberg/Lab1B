package Vehicles;

import java.awt.*;

import Carriers.IFerryCarrier;
import Positions.Direction;
import Ramps.Ramp;
import Ramps.ScaniaRamp;

/**
 * @author Lukas, Emil, Martin.
 * A class for truck Vehicles.Scania
 */

public class Scania extends Vehicle implements IFerryCarrier {
    private Ramp ramp;

    public Scania(int xPos, int yPos, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed, double enginePower, Color color, String modelName, ScaniaRamp ramp) {
        super(xPos, yPos, direction.NORTH, 0, true, 100, Color.DARK_GRAY, "Vehicles.Scania");
        this.ramp = ramp;
    }

    Ramp getRamp(){ return ramp; }
}

