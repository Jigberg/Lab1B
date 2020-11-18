package Ramps;

public class Car_TransportRamp extends Ramp {
    public Car_TransportRamp(int angle) {
        super(angle, 90, 0, 45);
    }

    @Override
    boolean isSecured() {
        return getAngle() == getMaxAngle();
    }
}
