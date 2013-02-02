package graphTheory.ui.button;

import graphTheory.ui.panel.LeftPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MatriceValidateButton extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LeftPanel leftPanel;
	
	

	public MatriceValidateButton(LeftPanel leftPanel) {
		super("Valider");
		this.leftPanel = leftPanel;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		leftPanel.updateMatrice();
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
