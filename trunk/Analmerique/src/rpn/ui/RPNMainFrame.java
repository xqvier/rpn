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
		JPanel fileSortiePanel = new FilePanel(ReversePoloneseNotation.getFileSortie(), "SORTIE");
		JPanel fileEntreePanel = new FilePanel(ReversePoloneseNotation.getFileEntree(), "ENTREE");
		processPilePanel.setVisible(true);
		poubellePilePanel.setVisible(true);
		fileEntreePanel.setVisible(true);
		fileSortiePanel.setVisible(true);
		
		mainPanel.add(processPilePanel,BorderLayout.WEST);
		mainPanel.add(poubellePilePanel, BorderLayout.EAST);
		mainPanel.add(fileEntreePanel, BorderLayout.NORTH);
		mainPanel.add(fileSortiePanel, BorderLayout.SOUTH);
		
		mainPanel.setVisible(true);
		this.add(mainPanel);
		
		
		
	}

}
