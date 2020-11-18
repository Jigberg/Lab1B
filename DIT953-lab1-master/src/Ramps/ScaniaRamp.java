package Ramps;

public class ScaniaRamp extends Ramp{
    public ScaniaRamp(int angle) {
        super(angle, 70, 0, 0);
    }

    @Override
    boolean isSecured() {
        return getAngle() == getMinAngle();
    }
}
