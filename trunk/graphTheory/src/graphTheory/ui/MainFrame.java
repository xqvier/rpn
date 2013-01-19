package graphTheory.ui;

import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;
import graphTheory.ui.panel.GraphPanel;
import graphTheory.ui.panel.LeftPanel;
import graphTheory.ui.param.Message;

import java.awt.Dimension;
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
		mainPanel.setLayout(new GridLayout(1, 3));
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());
		this.setSize(new Dimension(xSize, ySize));
		this.setContentPane(mainPanel);

		
		
		mainPanel.add(leftPanel);
		mainPanel.add(graphPanelOrigine);
		mainPanel.add(graphPanelFinal);
		
		
		
	}

	public Matrice getMatrice() {
		return matrice;
	}

	public void setMatrice(Matrice matrice) {
		this.matrice = matrice;
		graphPanelOrigine.drawGraph(matrice);
		
	}
	
	public void sendErrorMessage(String message){
		JOptionPane.showMessageDialog(this,
			    message);
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
