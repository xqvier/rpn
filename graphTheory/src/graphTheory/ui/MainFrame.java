package graphTheory.ui;

import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;
import graphTheory.ui.panel.GraphPanel;
import graphTheory.ui.panel.LeftPanel;
import graphTheory.ui.param.Message;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Matrice matrice = null;

	private ArrayList<Integer> levels = null;

	private LeftPanel leftPanel;
	private GraphPanel graphPanelOrigine = new GraphPanel();
	private GraphPanel graphPanelFinal = new GraphPanel();

	public MainFrame() {
		this.setVisible(true);
		JPanel mainPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calcul des niveaux d'un graphe");
		mainPanel.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(mainPanel);
		
		leftPanel = new LeftPanel(this);
		mainPanel.add(leftPanel, BorderLayout.WEST);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2, 1));

		rightPanel.setPreferredSize(new Dimension(getSize().width * 60 / 100,
				getSize().height));

		rightPanel.add(graphPanelOrigine);
		rightPanel.add(graphPanelFinal);

		mainPanel.add(rightPanel, BorderLayout.CENTER);

	}

	public Matrice getMatrice() {
		return matrice;
	}

	public void setMatrice(Matrice matrice) {
		this.matrice = matrice;
		graphPanelOrigine.drawGraph(matrice);

	}

	public void sendErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public ArrayList<Integer> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Integer> levels) {
		this.levels = levels;
	}

	public void drawLevels(Levels levels) {
		graphPanelFinal.drawGraphByLevel(matrice, levels);

	}

	public void thereIsCircuit() {
		leftPanel.disableCalculButton();
		sendErrorMessage(Message.MATRICE_CONTIENT_CIRCUIT);
	}

}
