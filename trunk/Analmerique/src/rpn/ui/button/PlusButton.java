package rpn.ui.button;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import rpn.main.Params;

public class PlusButton extends JButton implements MouseListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField vitesse;
	
	public PlusButton(JTextField pVitesse) {
		vitesse = pVitesse;
		this.setText("+");
		this.setFont(new Font(null, 0, 60));
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Params.WAIT_TIME+=500;
		vitesse.setText(Double.toString(Params.WAIT_TIME/1000.0));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
