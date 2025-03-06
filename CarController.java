import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController {
    // member fields:
    // A list of cars, modify if needed
    private ModelFacade model;
    private DrawPanel drawPanel;
    private CarFactory[] factories = {new VolvoFactory(), new SaabFactory(), new ScaniaFactory()};

    public CarController(ModelFacade model, DrawPanel drawPanel){
        this.model = model;
        this.drawPanel = drawPanel;
    }

    public void addCar(){
        if(model.cars.size() >= 10){
            return;
        }

        Random rand = new Random();

        Vehicle newCar = factories[ rand.nextInt(factories.length) ].createCar();
        
        model.cars.add(newCar);
        drawPanel.addCar(newCar);
    }

    public void removeCar(){
        if(model.cars.size() == 0){
            return;
        }

        model.cars.remove(model.cars.size()-1);
        drawPanel.removeCar(drawPanel.carImages.size()-1);
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : model.cars) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : model.cars) {
            car.brake(brake);
        }
    }

    void start() {
        for (Vehicle car : model.cars) {
            car.startEngine();
        }
    }

    void stop() {
        for (Vehicle car : model.cars) {
            car.stopEngine();
        }
    }

    void turboOn(){
        for (Vehicle car : model.cars) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle car : model.cars) {
            if(car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void raiseRamp(float amount){
        for (Vehicle car : model.cars) {
            if(car instanceof Scania){
                ((Scania)car).raiseRamp(amount);
            }
        }
    }

    void lowerRamp(float amount){
        for (Vehicle car : model.cars) {
            if(car instanceof Scania){
                ((Scania)car).lowerRamp(amount);
            }
        }
    }
}
