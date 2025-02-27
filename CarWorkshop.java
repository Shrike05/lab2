import java.awt.Point;
import java.util.ArrayList;

public class CarWorkshop<T extends Car> {
    private int maxCars;
    private ArrayList<T> cars;
    private Point position;
    
    public CarWorkshop(int maxCars, Point position){
        this.maxCars = maxCars;
        cars = new ArrayList<T>();
        this.position = position;
    }

    public Point getPosition(){
        return position;
    }

    public ArrayList<T> getCars(){
        return cars;
    }

    public void addCar(T car){
        if(cars.size() >= maxCars){
            throw new IllegalStateException("The workshop is already full of cars");
        }

        cars.add(car);
    }

    public T removeCar(int index){
        T car = cars.get(index);
        cars.remove(index);
        return car;
    }
}
