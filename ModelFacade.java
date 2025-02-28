import java.util.ArrayList;

public class ModelFacade {
    ArrayList<Vehicle> cars;
    CarWorkshop<Volvo240> volvoWorkshop;
    CarView frame;

    public ModelFacade(ArrayList<Vehicle> cars, CarWorkshop<Volvo240> volvoWorkshop, CarView frame){
        this.cars = cars;
        this.volvoWorkshop = volvoWorkshop;
        this.frame = frame;
    }
    
    public void gameLoop(){
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
