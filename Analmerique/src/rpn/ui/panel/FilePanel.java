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
import rpn.process.utils.MyQueue;

public class FilePanel extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private final int SIZE = 15;
	
	private MyQueue<Element> list;


	public FilePanel(String pName, MyQueue<Element> pFile) {
		this.setName(pName);
		pFile.addObservateur(new IObservateurList() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void update(IMyList pList) {
				list = (MyQueue<Element>) pList;
				FilePanel.this.update();
			}
		});
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(blackLine);
		this.setLayout(new GridLayout(1, SIZE));
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
		for (Element el : list) {			
			textField = new JTextField(el.getString());
			textField.setFont(new Font(null, 0, 25));
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
		}
		fill();
		this.validate();

	}
}
