package Vehicles;

import Carriers.Carrier;
import Carriers.FerryCarrier;
import Carriers.IFerryCarrier;
import Positions.Direction;

import java.awt.*;

public class Ferry extends Vehicle {
    private Carrier<IFerryCarrier, Ferry> carrier = new FerryCarrier(this);

    public Ferry(double x, double y, Direction direction, double currentSpeed, boolean isMovable, double enginePower, Color color, String modelName) {
        super(x, y, direction, currentSpeed, isMovable, enginePower, color, modelName);
    }
}
