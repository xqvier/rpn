package graphTheory.ui;

import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;
import graphTheory.ui.panel.GraphPanel;
import graphTheory.ui.panel.LeftPanel;
import graphTheory.ui.param.Message;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Matrice matrice = null;

	private ArrayList<Integer> levels = null;

	LeftPanel leftPanel = new LeftPanel(this);
	GraphPanel graphPanelOrigine = new GraphPanel();
	GraphPanel graphPanelFinal = new GraphPanel();

	public MainFrame() {
		JPanel mainPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calcul des niveaux d'un graphe");
		mainPanel.setLayout(new GridLayout(1, 2));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(mainPanel);

		mainPanel.add(leftPanel);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2, 1));

		rightPanel.add(graphPanelOrigine);
		rightPanel.add(graphPanelFinal);

		mainPanel.add(rightPanel);

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
