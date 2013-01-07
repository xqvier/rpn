package graphTheory.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import graphTheory.ui.panel.GraphPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setSize(new Dimension(800, 600));
		this.add(mainPanel);
		
		JPanel graphPanel = new GraphPanel();
		graphPanel.setBackground(Color.green);
		mainPanel.add(graphPanel, BorderLayout.CENTER);
		
	}
}
