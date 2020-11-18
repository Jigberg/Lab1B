package Ramps;

public abstract class Ramp {
    private boolean isSecured;
    private int angle;
    private int maxAngle;
    private int minAngle;
    private int loadableAngle;

    public Ramp(int angle, int maxAngle, int minAngle, int loadableAngle){
        this.isSecured = true;
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
        this.loadableAngle = loadableAngle;

    }
    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    void raiseRamp(int angle){
        setAngle(Math.min(raisableAngle(), angle));
        setisSecured(isSecured());
    }
    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    void lowerRamp(int angle) {
        setAngle(Math.min(lowerableAngle(), angle));
        setisSecured(isSecured());
    }
    void setLoadableAngle(){ setAngle(getLoadableAngle()); }
    int getLoadableAngle(){ return this.loadableAngle; }
    abstract boolean isSecured();
    int raisableAngle(){ return getMaxAngle() - getAngle(); }
    int lowerableAngle(){ return getAngle() - getMinAngle(); }
    public int getAngle(){ return this.angle; }
    void setAngle(int angle){ this.angle = angle; }
    public void setisSecured(boolean isSecured){ this.isSecured = isSecured; }
    boolean getIsSecured(){ return this.isSecured; }
    int getMaxAngle(){ return this.maxAngle; }
    int getMinAngle(){ return this.minAngle; }
}
