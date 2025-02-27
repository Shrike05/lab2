import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private static final String[] carImagePaths = { "pics/Volvo240.jpg", "pics/Saab95.jpg", "pics/Scania.jpg" };
    private static final Point[] carPoints = {new Point(), new Point(), new Point()};

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> carImages;
    BufferedImage volvoImage;
    // To keep track of a single car's position
    Point volvoPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, int i) {
        carPoints[i].x = x;
        carPoints[i].y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        carImages = new ArrayList<BufferedImage>();

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to
            // pics.
            // if you are starting in IntelliJ.
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
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < carImages.size(); i++){
            g.drawImage(carImages.get(i), carPoints[i].x, carPoints[i].y, null); // see javadoc for more info on the parameters
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
