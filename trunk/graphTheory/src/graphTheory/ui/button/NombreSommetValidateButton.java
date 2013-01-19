package graphTheory.ui.button;

import graphTheory.ui.panel.LeftPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NombreSommetValidateButton extends JButton implements
		MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LeftPanel leftPanel;
	
	public NombreSommetValidateButton(LeftPanel pLeftPanel) {		
		super("Valider");
		leftPanel = pLeftPanel;
		this.addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		leftPanel.createMatrice();
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
