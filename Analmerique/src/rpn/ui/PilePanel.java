package rpn.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import rpn.process.Element;
import rpn.process.MyStack;

public class PilePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private MyStack<Element> pile;
	
	
	
	public PilePanel(MyStack<Element> pPile, String pName) {
		pile = pPile;
		this.setName(pName);
		pile.setPanel(this);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		
		this.setBorder(blackLine);
		this.setVisible(true);
		myPaint();
	}
	
	public void myPaint(){
		this.removeAll();
		//this.add(new JTextArea(this.getName()));
		for (int i = pile.size()-1 ; i >= 0 ; i--) {
			this.add(new JTextArea(pile.get(i).getValeur().toString()), Component.CENTER_ALIGNMENT);
		}
		this.setSize(20,600);
		this.validate();
	}

	public void changed() {
		myPaint();
	}
	
	

}
