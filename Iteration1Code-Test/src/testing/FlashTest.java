package testing;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import view.DealDamageMapFlash;
import view.MapFlash;
import view.NullMapFlash;
import view.TakeDamageMapFlash;


public class FlashTest extends JFrame {
	MapFlash flash;
	static JPanel overlayPanel;
	
	public FlashTest() {
		super();
	}
	
	public static void main(String[] args) {
		FlashTest test = new FlashTest();
		JPanel jc = new TakeDamageMapFlash();
		overlayPanel = new NullMapFlash();
		overlayPanel.setLayout(new OverlayLayout(overlayPanel));
		overlayPanel.add(jc);
		test.add(overlayPanel);
		test.pack();
		test.setVisible(true);
		test.flash(new DealDamageMapFlash());
	}
	
	public void flash(MapFlash mf) {
		new FlashThread(mf).start();
}

private class FlashThread extends Thread {
	private MapFlash mf;
	private MapFlash temp;
	
	public FlashThread(MapFlash mf) {
		this.mf = mf;
	}
	
	@Override
	public void run() {
		
		try {
			sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//temp = flash;
		//flash = mf;
		
		overlayPanel.repaint();
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//flash = new NullMapFlash();
		overlayPanel.repaint();
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//flash = temp;
		
	}
}
}
