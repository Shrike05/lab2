import java.awt.*;

public class Scania extends Truck implements RampInterface{

    private Ramp ramp;
    private ScaniaState state;

    public Scania(){
        state = new ScaniaRampHightened();
        ramp = new Ramp(0, 70, 0);

        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        setModelName("Saab95");
        stopEngine();
    }

    public Ramp getRamp(){
        return ramp;
    }

    public void raiseRamp(double angle){
        if(getCurrentSpeed() > 0){
            throw new IllegalStateException("The ramp cannot be heightened whilst the vehicle is in motion");
        }

        ramp.setRampAngle(angle);
        state = new ScaniaRampHightened();
    }

    public void lowerRamp(double angle){
        if(getCurrentSpeed() > 0){
            throw new IllegalStateException("The ramp cannot be lowered whilst the vehicle is in motion");
        }

        ramp.setRampAngle(angle);
        state = new ScaniaRampLowered();
    }

    public void move(){
        state.move(this);
    }
    
    public void startEngine(){
        state.startEngine(this);
    }
}
