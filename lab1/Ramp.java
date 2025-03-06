public class Ramp implements RampInterface {
    double rampAngleDeg;
    double rampMaxAngleDeg;
    double rampMinAngleDeg;

    public Ramp(double rampAngleDeg, double rampMaxAngleDeg, double rampMinAngleDeg){
        this.rampAngleDeg = Math.max(Math.min(rampAngleDeg, rampMaxAngleDeg), rampMinAngleDeg);
        this.rampMaxAngleDeg = rampMaxAngleDeg;
        this.rampMinAngleDeg = rampMinAngleDeg;
    }

    public double getRampAngle(){
        return rampAngleDeg;
    }

    public double getMaxRampAngle(){
        return rampMaxAngleDeg;
    }

    public double getMinRampAngle(){
        return rampMinAngleDeg;
    }

    public void setRampAngle(double rampAngleDeg){
        this.rampAngleDeg = Math.max(Math.min(rampAngleDeg, rampMaxAngleDeg), rampMinAngleDeg);
    }

    public void raiseRamp(double angle){
        setRampAngle(angle);
    }

    public void lowerRamp(double angle){
        setRampAngle(angle);
    }
}
