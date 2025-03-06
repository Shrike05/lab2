import java.util.ArrayList;

public class ModelFacade {
    CarController cc;
    CarView frame;

    public ModelFacade(CarController cc, CarView frame){
        this.cc = cc;
        this.frame = frame;
    }
    
    public void gameLoop(){
        for (int i = 0; i < cc.cars.size(); i++) {
            Vehicle car = cc.cars.get(i);

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

            if(car.getPosition().distance(cc.volvoWorkshop.getPosition()) < 10 && car instanceof Volvo240){
                cc.volvoWorkshop.addCar((Volvo240) car);
                cc.cars.remove(i);
                frame.drawPanel.removeCar(i);
            }

        }
        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
    }
}
