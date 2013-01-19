package graphTheory.ui.panel;

import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;
import graphTheory.process.service.MatriceService;
import graphTheory.ui.MainFrame;
import graphTheory.ui.button.CalculButton;
import graphTheory.ui.button.MatriceExempleButton;
import graphTheory.ui.button.MatriceValidateButton;
import graphTheory.ui.button.NombreSommetValidateButton;
import graphTheory.ui.button.StepByStepActivateButton;
import graphTheory.ui.button.StepByStepNextButton;
import graphTheory.ui.param.Message;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	private JPanel nombreSommetPanel = new JPanel();
	private JTextField nombreSommetField = new JTextField();
	private NombreSommetValidateButton nombreSommetValidateButton = new NombreSommetValidateButton(
			this);
	private JPanel matriceExemplePanel = new JPanel();
	private MatriceExempleButton matriceExempleButton3 = new MatriceExempleButton(
			this, 3);
	private MatriceExempleButton matriceExempleButton4 = new MatriceExempleButton(
			this, 4);
	private MatriceExempleButton matriceExempleButton5 = new MatriceExempleButton(
			this, 5);

	private MatricePanel matricePanel = new MatricePanel();
	private NiveauPanel niveauPanel = new NiveauPanel();
	private MatriceValidateButton matriceValidateButton = new MatriceValidateButton(
			this);
	private CalculButton calculButton = new CalculButton(this);
	private JPanel stepByStepPanel = new JPanel();
	private StepByStepActivateButton stepByStepActivateButton = new StepByStepActivateButton();
	private StepByStepNextButton stepByStepNextButton = new StepByStepNextButton();

	public LeftPanel(MainFrame pMainFrame) {
		mainFrame = pMainFrame;
		this.setLayout(new GridLayout(7, 1));

		// NOMBRE SOMMET
		nombreSommetPanel.setLayout(new GridLayout(1, 2));
		nombreSommetField.setHorizontalAlignment(JTextField.CENTER);
		nombreSommetPanel.add(nombreSommetField);
		nombreSommetPanel.add(nombreSommetValidateButton);
		this.add(nombreSommetPanel);

		// MATRICE EXEMPLE
		matriceExemplePanel.setLayout(new GridLayout(1, 3));
		matriceExemplePanel.add(matriceExempleButton3);
		matriceExemplePanel.add(matriceExempleButton4);
		matriceExemplePanel.add(matriceExempleButton5);
		this.add(matriceExemplePanel);
		
		// MATRICE
		this.add(matricePanel);

		// NIVEAUX
		this.add(niveauPanel);

		// VALIDER MATRICE
		this.add(matriceValidateButton);

		// CALCUL
		this.add(calculButton);

		// STEP BY STEP
		stepByStepPanel.setLayout(new GridLayout(1, 2));
		stepByStepPanel.add(stepByStepActivateButton);
		stepByStepPanel.add(stepByStepNextButton);
		this.add(stepByStepPanel);

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
		niveauPanel.setLevels(new Levels(0));
	}

	public void createMatrice(int n) {
		Matrice matrice = new Matrice(n);

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
		niveauPanel.setLevels(new Levels(0));
		calculButton.setEnabled(false);
	}

	public void updateMatrice() {
		Matrice matrice;
		try {
			matrice = matricePanel.getMatrice();
		} catch (NumberFormatException e) {
			mainFrame.sendErrorMessage(Message.MAUVAIS_RENSEIGNEMENT_MATRICE);
			return;

		}

		calculButton.setEnabled(true);
		if (MatriceService.isThereAnyCircuit(matrice)) {
			mainFrame.sendErrorMessage(Message.MATRICE_CONTIENT_CIRCUIT);
			calculButton.setEnabled(false);
		}

		mainFrame.setMatrice(matrice);
		niveauPanel.setLevels(new Levels(0));

	}

	public void calculLevels() {
		Levels levels = new Levels(mainFrame.getMatrice().getSize());
		niveauPanel.setLevels(levels);
		mainFrame.drawLevels(levels);
		MatriceService matriceService = new MatriceService();
		matriceService.start();
		MatriceService.calculateLevel(mainFrame.getMatrice(), levels);
		System.out.println(levels);

	}
}
