public class ScaniaRampHightened implements ScaniaState {
    @Override
    public void startEngine(Scania scania) {
        System.out.println("Run");
        scania.startEngine();
    }
    
}
