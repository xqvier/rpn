package graphTheory.ui.panel;

import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;
import graphTheory.process.service.MatriceServiceCircuit;
import graphTheory.process.service.MatriceServiceLevel;
import graphTheory.ui.MainFrame;
import graphTheory.ui.button.CalculButton;
import graphTheory.ui.button.MatriceValidateButton;
import graphTheory.ui.button.StepByStepActivateButton;
import graphTheory.ui.button.StepByStepNextButton;
import graphTheory.ui.param.Message;
import graphTheory.ui.param.Params;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	private JPanel nombreSommetPanel = new JPanel();
	private JTextField nombreSommetField = new JTextField();
	private MatriceExemplePanel matriceExemplePanel = new MatriceExemplePanel(
			this);
	private MatricePanel matricePanel = new MatricePanel();
	private NiveauPanel niveauPanel = new NiveauPanel();
	private CalculButton calculButton = new CalculButton(this);
	private JPanel stepByStepPanel = new JPanel();
	private StepByStepActivateButton stepByStepActivateButton = new StepByStepActivateButton();
	private StepByStepNextButton stepByStepNextButton = new StepByStepNextButton();
	private CalculBar calculBar = new CalculBar();

	public LeftPanel(MainFrame pMainFrame) {
		mainFrame = pMainFrame;
		this.setLayout(new BorderLayout());

		// NOMBRE SOMMET
		nombreSommetPanel.setLayout(new GridLayout(1, 2));
		nombreSommetField.setHorizontalAlignment(JTextField.CENTER);
		nombreSommetField.setPreferredSize(new Dimension(
				Params.CASE_SOMMET_WIDTH, Params.CASE_SOMMET_HEIGHT));
		JPanel nombreSommetFieldPanel = new JPanel();
		nombreSommetFieldPanel.setLayout(new GridBagLayout());
		nombreSommetFieldPanel.add(nombreSommetField);
		nombreSommetPanel.add(nombreSommetFieldPanel);
		this.add(nombreSommetPanel, BorderLayout.NORTH);

		// MATRICE EXEMPLE
		nombreSommetPanel.add(matriceExemplePanel);

		// MATRICE
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());

		centerPanel.add(matricePanel, BorderLayout.CENTER);

		// NIVEAUX
		niveauPanel.setPreferredSize(new Dimension(200, 50));
		centerPanel.add(niveauPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);

		// CALCUL
		stepByStepPanel.add(calculButton);

		// STEP BY STEP
		stepByStepPanel.setLayout(new BorderLayout());
		stepByStepPanel.add(calculBar, BorderLayout.NORTH);

		stepByStepPanel.add(calculButton, BorderLayout.CENTER);

		stepByStepPanel.add(stepByStepActivateButton, BorderLayout.SOUTH);
		stepByStepPanel.add(stepByStepNextButton, BorderLayout.SOUTH);
		this.add(stepByStepPanel, BorderLayout.SOUTH);

	}

	public void createMatrice() {
		Integer nombreSommet;
		try {
			nombreSommet = Integer.valueOf(nombreSommetField.getText());
		} catch (NumberFormatException e) {
			mainFrame.sendErrorMessage(Message.MAUVAIS_SOMMET_RENSEIGNER);
			return;

		}
		if (nombreSommet <= 0) {
			mainFrame.sendErrorMessage(Message.MAUVAIS_SOMMET_RENSEIGNER);

		}
		mainFrame.setMatrice(new Matrice(nombreSommet));
		matricePanel.setMatrice(mainFrame.getMatrice());
		calculBar.setMatrice(mainFrame.getMatrice());
		niveauPanel.setLevels(new Levels(0));
	}

	public void createMatrice(int n) {
		Matrice matrice = new Matrice(n);

		if (!nombreSommetField.getText().equals("")) {
			createMatrice();
		} else {
			switch (n) {
			case 3:
				matrice.getCaseList().get(0).get(1).setValue(1);
				matrice.getCaseList().get(1).get(2).setValue(1);
				break;
			case 4:
				matrice.getCaseList().get(0).get(1).setValue(1);
				matrice.getCaseList().get(0).get(2).setValue(1);
				matrice.getCaseList().get(1).get(3).setValue(1);
				matrice.getCaseList().get(2).get(1).setValue(1);
				matrice.getCaseList().get(2).get(3).setValue(1);
				break;
			case 5:
				matrice.getCaseList().get(1).get(0).setValue(1);
				matrice.getCaseList().get(1).get(3).setValue(1);
				matrice.getCaseList().get(2).get(1).setValue(1);
				matrice.getCaseList().get(2).get(3).setValue(1);
				matrice.getCaseList().get(3).get(4).setValue(1);
				break;
			}
			mainFrame.setMatrice(matrice);
			matricePanel.setMatrice(matrice);
			calculBar.setMatrice(matrice);

			niveauPanel.setLevels(new Levels(0));
		}
	}

	public void updateMatrice() {
		Matrice matrice;
		try {
			matrice = matricePanel.getMatrice();
		} catch (NumberFormatException e) {
			mainFrame.sendErrorMessage(Message.MAUVAIS_RENSEIGNEMENT_MATRICE);
			return;

		}

		MatriceServiceCircuit matriceServiceCircuit = new MatriceServiceCircuit(
				matrice, mainFrame);
		matriceServiceCircuit.start();

		calculBar.setMatrice(mainFrame.getMatrice());
		mainFrame.setMatrice(matrice);
		niveauPanel.setLevels(new Levels(0));

	}

	public void calculLevels() {
		Levels levels = new Levels(mainFrame.getMatrice().getSize());
		niveauPanel.setLevels(levels);
		mainFrame.drawLevels(levels);
		MatriceServiceLevel matriceServiceLevel = new MatriceServiceLevel(
				mainFrame.getMatrice(), levels);
		matriceServiceLevel.start();
		System.out.println(levels);

	}

	public void disableCalculButton() {
	}
}
