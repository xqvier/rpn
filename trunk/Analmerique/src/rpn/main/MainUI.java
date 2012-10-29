package rpn.main;

import javax.swing.JFrame;

import rpn.ui.RPNMainFrame;


public class MainUI extends Thread {

	@Override
	public void run() {
		JFrame main = new RPNMainFrame();
		main.setSize(800, 600);
		main.setVisible(true);
	}

}
