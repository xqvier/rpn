package rpn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import rpn.process.utils.Element;
import rpn.process.utils.MyDouble;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;
import rpn.ui.panel.CommandPanel;
import rpn.ui.panel.FilePanel;
import rpn.ui.panel.PilePanel;

public class RPNMainFrame extends JFrame{

	private static final long serialVersionUID = 1L;


	public RPNMainFrame(int width, int height) {
		this.setSize(new Dimension(width, height));

		MyQueue<Element> fileEntree = new MyQueue<Element>();
		MyQueue<Element> fileSortie = new MyQueue<Element>();
		MyStack<Element> pileProcess = new MyStack<Element>();
		MyStack<Element> pilePoubelle = new MyStack<Element>();
		MyDouble resultat = new MyDouble();
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
						
		mainPanel.setLayout(new BorderLayout());
		JPanel processPilePanel = new PilePanel("PROCESS", pileProcess);
		JPanel poubellePilePanel = new PilePanel("POUBELLE", pilePoubelle);
		JPanel fileSortiePanel = new FilePanel("SORTIE", fileSortie);
		JPanel fileEntreePanel = new FilePanel("ENTREE", fileEntree);
		
		JPanel filesPanel = new JPanel();
		filesPanel.setPreferredSize(new Dimension(600, 100));
		mainPanel.add(filesPanel, BorderLayout.SOUTH);
		processPilePanel.setPreferredSize(new Dimension(75,500));
		poubellePilePanel.setPreferredSize(new Dimension(75,500));
		
		
		
		filesPanel.setLayout(new GridLayout(2, 1));
		filesPanel.add(fileEntreePanel);
		filesPanel.add(fileSortiePanel);
	
		
		mainPanel.add(processPilePanel, BorderLayout.WEST);
		mainPanel.add(poubellePilePanel, BorderLayout.EAST);
		mainPanel.add(filesPanel, BorderLayout.SOUTH);
		
		JPanel commandPannel = new CommandPanel(fileEntree, fileSortie, pileProcess, pilePoubelle, resultat);
		
		mainPanel.add(commandPannel, BorderLayout.CENTER);
		
		
		mainPanel.setVisible(true);
		
		processPilePanel.setVisible(true);
		poubellePilePanel.setVisible(true);
		fileEntreePanel.setVisible(true);
		fileSortiePanel.setVisible(true);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Reverse Polonese Notation");
		
		this.setContentPane(mainPanel);
		
	}


}
