package rpn.ui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayDeque;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import rpn.main.IObservateurList;
import rpn.process.utils.Element;
import rpn.process.utils.MyStack;

public class PilePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private boolean add = false;
	
	private ArrayDeque<String> pile = new ArrayDeque<String>();

	public PilePanel(String pName, MyStack<Element> pPile) {
		this.setName(pName);
		pPile.addObservateur(new IObservateurList() {
			@Override
			public void remove() {
				pile.remove();
				add = false;
				update();
			}

			@Override
			public void add(String value) {
				pile.add(value);
				add = true;
				update();

			}

			@Override
			public void clear() {
				pile.clear();
				add = false;
				update();
			}
		});
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(blackLine);
		this.setVisible(true);
		
	}

	public void update() {
		this.removeAll();
		this.setLayout(new GridLayout(pile.size(), 1));
		JTextField textField;
		Iterator<String> it = pile.descendingIterator();
		int i = 1;
		while (it.hasNext()) {
			String el = it.next();
			textField = new JTextField(el);
			if(add && i == 1){
				textField.setBackground(Color.GREEN);
			}
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
			i++;
		}
		if(!add){
			textField = new JTextField();
			textField.setBackground(Color.RED);
			this.add(textField);
		}
		this.validate();
	}

}
