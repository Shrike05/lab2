import javax.swing.*;

public class App {
    
    public static void main(String[] args) {
        DrawPanel drawPanel = new DrawPanel(CarView.X, CarView.Y-240);

        // Instance of this class
        ModelFacade modelFacade = new ModelFacade(drawPanel);
        
        CarController cc = new CarController(modelFacade, drawPanel);

        new CarView("CarSim 1.0", cc, drawPanel);

        Timer timer = new Timer(50, new TimerListener(modelFacade));
        // Start the timer
        timer.start();
    }
}