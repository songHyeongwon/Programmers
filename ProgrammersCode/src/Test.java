import java.awt.Robot;
import java.awt.event.InputEvent;

public class Test {
	public static void main(String[] args) {
		try {
			Robot r = new Robot();
			r.delay(1000 * 10);
			while(true) {
				r.mouseMove(500, 827);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.delay(100);
				r.mouseMove(550, 850);
				r.delay(1000);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(1000 * 60);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
