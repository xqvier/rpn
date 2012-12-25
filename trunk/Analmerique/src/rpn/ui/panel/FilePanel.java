package rpn.ui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import rpn.main.IObservateurList;
import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;

public class FilePanel extends JPanel {

	private boolean add = false;

	private static final long serialVersionUID = 1L;

	LinkedList<String> file = new LinkedList<String>();

	public FilePanel(String pName, MyQueue<Element> pFile) {
		this.setName(pName);
		pFile.addObservateur(new IObservateurList() {
			@Override
			public void remove() {
				file.remove();
				add = false;
				update();
			}

			@Override
			public void add(String value) {
				file.add(value);
				add = true;
				update();

			}

			@Override
			public void clear() {
				file.clear();
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
		this.setLayout(new GridLayout(1, file.size()));
		JTextField textField;
		int i = 1; 
		if(!add){
			textField = new JTextField();
			textField.setBackground(Color.RED);
			this.add(textField);
		}
			
		for (String value : file) {
			
			textField = new JTextField(value);
			if(add && i == file.size()){
				textField.setBackground(Color.GREEN);
			}
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
			i++;
		}
		this.validate();

	}
}
