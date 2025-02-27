import javax.swing.*;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();

    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(4, new Point(0,300));

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        Saab95 saab = new Saab95();
        saab.setY(100);
        cc.cars.add(saab);
        Scania scania = new Scania();
        scania.setY(200);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                Vehicle car = cars.get(i);

                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y, i);

                if(x >= frame.getWidth() - frame.drawPanel.carImages.get(i).getWidth()){
                    car.turnLeft();
                    car.turnLeft();
                }else if(x < 0){
                    car.turnLeft();
                    car.turnLeft();
                }else if(y >= frame.getHeight() - 240 - frame.drawPanel.carImages.get(i).getHeight()){
                    car.turnLeft();
                    car.turnLeft();
                }else if(y < 0){
                    car.turnLeft();
                    car.turnLeft();
                }

                if(car.getPosition().distance(volvoWorkshop.getPosition()) < 10 && car instanceof Volvo240){
                    volvoWorkshop.addCar((Volvo240) car);
                    cars.remove(i);
                    frame.drawPanel.carImages.remove(i);
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    void start() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stop() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void turboOn(){
        for (Vehicle car : cars) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle car : cars) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void raiseRamp(float amount){
        for (Vehicle car : cars) {
            if(car instanceof Scania){
                ((Scania)car).raiseRamp(amount);
            }
        }
    }

    void lowerRamp(float amount){
        for (Vehicle car : cars) {
            if(car instanceof Scania){
                ((Scania)car).lowerRamp(amount);
            }
        }
    }
}
