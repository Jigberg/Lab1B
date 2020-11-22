package Vehicles;

import Carriers.CarTransportCarrier;
import Carriers.Carrier;
import Carriers.ICarTransportCarrier;
import Carriers.IFerryCarrier;
import Positions.Direction;
import Positions.Movables;
import Ramps.Ramp;

import java.awt.*;
import java.util.*;

/**
 * @author Lukas, Emil, Martin.
 * A class for truck Vehicles.Scania
 */

public class Car_Transport extends Vehicle implements IFerryCarrier {
    Carrier<ICarTransportCarrier, Car_Transport> carrier = new CarTransportCarrier(this);
    Ramp ramp; 

    public Car_Transport(double x, double y, Direction direction, double currentspeed, boolean isMovable, Color color, Ramp ramp) {
        super(x, y, direction, currentspeed, isMovable, 200, color, "Car Transport AB");
        this.ramp = ramp;
    }
    /**
     * Moves the car depending on direction. Also moves cars on transport.
     */
    @Override
    public void move() {
        if(getIsMovable()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getCurrentSpeed());
                case EAST -> setx(getx() + getCurrentSpeed());
                case SOUTH -> sety(gety() - getCurrentSpeed());
                case WEST -> setx(getx() - getCurrentSpeed());
                default -> System.out.print("non valid direction!");
            }
        }
        for(ICarTransportCarrier load : getCarrier().getLoad()){
            ((Movables) load).setx(getx());
            ((Movables) load).sety(gety());
        }
    }

    /**
     * Turns the car left. Also moves cars in transport.
     */
    @Override
    public void turnLeft() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.WEST);
            case EAST -> setDirection(Direction.NORTH);
            case SOUTH -> setDirection(Direction.EAST);
            case WEST -> setDirection(Direction.SOUTH);
        }
        for(Object load: getCarrier().getLoad()){
            ((Movables) load).setDirection(getDirection());
        }
    }

    /**
     * Turns the car right. Also moves cars in transport.
     */
    public void turnRight() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.EAST);
            case EAST -> setDirection(Direction.SOUTH);
            case SOUTH -> setDirection(Direction.WEST);
            case WEST -> setDirection(Direction.NORTH);
        }
        for(Object load: getCarrier().getLoad()){
            ((Movables) load).setDirection(getDirection());
        }
    }

    public Carrier<ICarTransportCarrier, Car_Transport> getCarrier(){ return this.carrier; }
    public Ramp getRamp(){return this.ramp; }
}
