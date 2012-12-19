package rpn.ui.button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import rpn.process.Calcul;
import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;


public class CalculButton extends JButton implements MouseListener {


	private static final long serialVersionUID = 1L;
	
	
	JTextField resultatField;
	MyQueue<Element> fileSortie;
	MyStack<Element> pileProcess;
	
	public CalculButton(MyQueue<Element> pFileSortie, MyStack<Element> pPileProcess, JTextField pResultatField, String pName) {
		super(pName);
		fileSortie = pFileSortie;
		pileProcess = pPileProcess;
		resultatField = pResultatField;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Calcul calcul = new Calcul(pileProcess, fileSortie);
		
		resultatField.setText(Double.toString(calcul.run()));
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
