package rpn.ui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import rpn.main.IObservateurList;
import rpn.process.utils.Element;
import rpn.process.utils.IMyList;
import rpn.process.utils.MyStack;

public class PilePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private MyStack<Element> list;

	public PilePanel(String pName, MyStack<Element> pPile) {
		this.setName(pName);
		pPile.addObservateur(new IObservateurList() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void update(IMyList pList) {
				list = (MyStack<Element>) pList;
				PilePanel.this.update();
			}
		});
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(blackLine);
		this.setVisible(true);
		
	}

	public void update() {
		this.removeAll();
		this.setLayout(new GridLayout(list.size(), 1));
		JTextField textField;
		Iterator<Element> it = list.descendingIterator();
		while (it.hasNext()) {
			Element el = it.next();
			textField = new JTextField(el.getString());
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
		}
		this.validate();
	}

}
