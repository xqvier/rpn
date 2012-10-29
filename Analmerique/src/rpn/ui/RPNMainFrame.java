package rpn.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import rpn.process.ReversePoloneseNotation;

public class RPNMainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public RPNMainFrame() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		mainPanel.setLayout(new BorderLayout());
		JPanel processPilePanel = new PilePanel(ReversePoloneseNotation.getPileOperateur(), "PROCESS");
		JPanel poubellePilePanel = new PilePanel(ReversePoloneseNotation.getPoubelle(), "POUBELLE");
		processPilePanel.setVisible(true);
		poubellePilePanel.setVisible(true);
		
		mainPanel.add(processPilePanel,BorderLayout.WEST);
		mainPanel.add(poubellePilePanel, BorderLayout.EAST);
		
		mainPanel.setVisible(true);
		this.add(mainPanel);
		
		
		
	}

}
