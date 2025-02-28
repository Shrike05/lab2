import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerListener implements ActionListener {
    ModelFacade modelFacade;

    public TimerListener(ModelFacade modelFacade){
        this.modelFacade = modelFacade;
    }

    public void actionPerformed(ActionEvent e) {
        modelFacade.gameLoop();
    }
}