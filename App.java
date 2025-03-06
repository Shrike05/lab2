import javax.swing.*;

public class App {
    
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        CarView frame = new CarView("CarSim 1.0", cc);

        ModelFacade modelFacade = new ModelFacade(cc, frame);

        Timer timer = new Timer(50, new TimerListener(modelFacade));
        // Start the timer
        timer.start();
    }
}