import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private static final String[] carImagePaths = { "pics/Volvo240.jpg", "pics/Saab95.jpg", "pics/Scania.jpg" };
    private ArrayList<Point> carPoints = new ArrayList<Point>();

    ArrayList<BufferedImage> carImages = new ArrayList<BufferedImage>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);

    void moveit(int x, int y, int i) {
        carPoints.get(i).x = x;
        carPoints.get(i).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        for(int i = 0; i < 3; i++){
            carPoints.add(new Point());
        }

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            for (String path : carImagePaths) {
                carImages.add(
                        ImageIO.read(
                                DrawPanel.class.getResourceAsStream(path)));

            }
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < carImages.size(); i++){
            g.drawImage(carImages.get(i), carPoints.get(i).x, carPoints.get(i).y, null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    public void removeCar(int i){
        carImages.remove(i);
    }

    public void addCar(Vehicle car){
        String imagePath = "";
        if(car instanceof Volvo240){
            imagePath = carImagePaths[0];
        }else if(car instanceof Saab95){
            imagePath = carImagePaths[1];
        }else if(car instanceof Scania){
            imagePath = carImagePaths[2];
        }

        try {
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        carPoints.add(new Point());
    }
}
