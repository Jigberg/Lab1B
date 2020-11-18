package DumbAssKangarooPackage;

public interface Ramp {

    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    void raiseRamp(int angle);

    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    void lowerRamp(int angle);

    int getRampAngle();

    void setRampAngle(int platformAngle);
}
