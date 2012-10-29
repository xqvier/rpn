package rpn.ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import rpn.process.Element;
import rpn.process.MyQueue;

public class FilePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private MyQueue<Element> file;
	public FilePanel(MyQueue<Element> pFile, String pName) {
		file = pFile;
		this.setName(pName);
		file.setPanel(this);
		this.setLayout(new FlowLayout());
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		
		this.setBorder(blackLine);
		this.setVisible(true);
		myPaint();
	}
	
	public void myPaint(){
		this.removeAll();
		//this.add(new JTextArea(this.getName()));
		for(Element element : file){
			this.add(new JTextArea(element.getValeur().toString()));
		}
		this.setSize(800,30);
		this.validate();
	}

	public void changed() {
		myPaint();
	}
}
