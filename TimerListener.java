import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TimerListener implements ActionListener {
    public ArrayList<TimerObserver> observers;

    public TimerListener(ArrayList<TimerObserver> observers){
        this.observers = observers;
    }

    public void actionPerformed(ActionEvent e) {
        for (TimerObserver timerObserver : observers) {
            timerObserver.update();
        }
    }
}