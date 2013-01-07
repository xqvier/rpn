package rpn.ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

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
	
	private final int SIZE = 15;
	

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
		this.setLayout(new GridLayout(SIZE, 1));
		fill();
		this.setVisible(true);
		
	}
	private void fill(){
		int i = list != null ? list.size() : 0;
		for(; i < SIZE ; i++){
			this.add(new JTextField());
		}
	}

	public void update() {
		this.removeAll();
		JTextField textField;
		for(int j = list.size() -1 ; j>= 0 ; j--){
			textField = new JTextField(list.get(j).getString());
			textField.setFont(new Font(null, 0, 25));
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
		}
		fill();
		this.validate();
	}

}
