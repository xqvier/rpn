package rpn.ui.button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import rpn.process.ReversePoloneseNotation;
import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;


public class ProcessRPNButton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	MyQueue<Element> fileEntree;
	MyQueue<Element> fileSortie;
	MyStack<Element> pileProcess;
	MyStack<Element> pilePoubelle;
	
	
	public ProcessRPNButton(MyQueue<Element> pFileEntree, MyQueue<Element> pFileSortie,MyStack<Element> pPileProcess,MyStack<Element> pPilePoubelle,  String pName) {
		super(pName);
		fileEntree = pFileEntree;
		fileSortie = pFileSortie;
		pilePoubelle = pPilePoubelle;
		pileProcess = pPileProcess;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ReversePoloneseNotation rpn = new ReversePoloneseNotation(fileEntree,fileSortie,pileProcess,pilePoubelle);
		try {
			rpn.run();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
