package rpn.ui.button;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import rpn.main.Params;


public class StepByStepActivateButton extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StepByStepActivateButton() {
		if(Params.STEP_BY_STEP){
			setText("Désactiver le mode pas à pas");
			setBackground(Color.GREEN);
		}else {
			setText("Activer le mode pas à pas");
			setBackground(Color.RED);
		}
		addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(Params.STEP_BY_STEP){
			setText("Activer le mode pas à pas");			
			setBackground(Color.RED);
			Params.STEP_BY_STEP = false;
		} else {
			setText("Désactiver le mode pas à pas");
			setBackground(Color.GREEN);
			Params.STEP_BY_STEP = true;
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
