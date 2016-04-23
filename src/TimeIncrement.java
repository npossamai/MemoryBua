import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class TimeIncrement extends java.util.TimerTask{

	JProgressBar bar;
	JFrame frame;
	Timer timer;
	
	public TimeIncrement(JProgressBar bar, JFrame frame, Timer t) {
		this.bar = bar;
		this.frame = frame;
		this.timer = t;
	}
	@Override
	public void run() {
		bar.setValue(bar.getValue()+1);
		if (bar.getValue()>=bar.getMaximum()){
			frame.repaint();
			JOptionPane.showMessageDialog(null, "HAI PERSO!\n\nTempo scaduto!",null, JOptionPane.INFORMATION_MESSAGE);
			timer.cancel();
			frame.dispose();
		}
		
	}

}
