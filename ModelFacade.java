import java.awt.Point;
import java.util.ArrayList;

public class ModelFacade {
    public ArrayList<Vehicle> cars = new ArrayList<Vehicle>();

    public CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(4, new Point(300,300));


    DrawPanel frame;

    public ModelFacade(DrawPanel frame){
        this.frame = frame;

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
    
    public void gameLoop(){
        for (int i = 0; i < cars.size(); i++) {
            Vehicle car = cars.get(i);

            car.move();
            int x = (int) Math.round(car.getPosition().getX());
            int y = (int) Math.round(car.getPosition().getY());
            frame.moveit(x, y, i);

            if(x >= frame.getWidth() - frame.carImages.get(i).getWidth()){
                car.turnLeft();
                car.turnLeft();
            }else if(x < 0){
                car.turnLeft();
                car.turnLeft();
            }else if(y >= frame.getHeight() - frame.carImages.get(i).getHeight()){
                car.turnLeft();
                car.turnLeft();
            }else if(y < 0){
                car.turnLeft();
                car.turnLeft();
            }

            if(car.getPosition().distance(volvoWorkshop.getPosition()) < 10 && car instanceof Volvo240){
                volvoWorkshop.addCar((Volvo240) car);
                cars.remove(i);
                frame.removeCar(i);
            }

        }
        // repaint() calls the paintComponent method of the panel
        frame.repaint();
    }
}
