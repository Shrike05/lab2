public class ScaniaRampHightened implements ScaniaState {
    @Override
    public void startEngine(Scania scania) {
        System.out.println("Run");
        scania.startEngine();
    }

    @Override
    public void move(Scania scania) {
        scania.move();
    }
    
}
