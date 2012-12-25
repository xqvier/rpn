package rpn.ui.button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import rpn.process.Decoupe;
import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;

public class DecoupeButton extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField calculField;

	private MyQueue<Element> fileEntree;

	public DecoupeButton(MyQueue<Element> pFileEntree, JTextField pCalculField,
			String pName) {
		super(pName);
		fileEntree = pFileEntree;
		calculField = pCalculField;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Decoupe decoupe = new Decoupe(fileEntree, calculField.getText());

		decoupe.start();

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
