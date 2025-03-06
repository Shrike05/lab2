import java.awt.Point;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // A list of cars, modify if needed
    public ArrayList<Vehicle> cars = new ArrayList<Vehicle>();

    public CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(4, new Point(0,300));

    public CarController(){
        SaabFactory saabFactory = new SaabFactory(); 
        VolvoFactory volvoFactory = new VolvoFactory(); 
        ScaniaFactory scaniaFactory = new ScaniaFactory(); 
        
        cars.add(volvoFactory.createCar());

        Saab95 saab = saabFactory.createCar();
        saab.setY(100);
        cars.add(saab);
        
        Scania scania = scaniaFactory.createCar();
        scania.setY(200);
        cars.add(scania);
    }

    public void addCar(Vehicle car){
        cars.add(car);
    }

    public void removeCar(int i){
        cars.remove(i);
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
