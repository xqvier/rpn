package rpn.ui.panel;

import java.awt.Color;
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
		this.setVisible(true);

	}

	public void update() {
		this.removeAll();
		this.setLayout(new GridLayout(1, list.size()));
		JTextField textField;				
		for (Element el : list) {			
			textField = new JTextField(el.getString());
			textField.setHorizontalAlignment(JTextField.CENTER);
			this.add(textField);
		}
		this.validate();

	}
}
