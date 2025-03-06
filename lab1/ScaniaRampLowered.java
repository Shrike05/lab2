public class ScaniaRampLowered implements ScaniaState {
    @Override
    public void startEngine(Scania scania) {
        System.out.println("Can't Run");
    }

    @Override
    public void move(Scania scania) {
        System.out.println("Cannot drive whilst ramp is down");
    }
}
