package graphTheory.ui.button;

import graphTheory.ui.panel.LeftPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MatriceExempleButton extends JButton implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int n;
	private LeftPanel leftPanel;
	
	
	public MatriceExempleButton(LeftPanel pLeftPanel, int n) {
		leftPanel = pLeftPanel;
		this.n = n;
		switch(n){
		case 3 :
			this.setText("3x3");
			break;
		case 4 :
			this.setText("4x4");
			break;
		case 5 :
			this.setText("5x5");
			break;
		}
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		leftPanel.createMatrice(n);
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
