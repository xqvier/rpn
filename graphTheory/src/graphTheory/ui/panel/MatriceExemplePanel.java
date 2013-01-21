package graphTheory.ui.panel;

import java.awt.GridLayout;

import graphTheory.ui.button.NombreSommetValidateButton;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

public class MatriceExemplePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton matrice3 = new JRadioButton("3x3");
	private JRadioButton matrice4 = new JRadioButton("4x4");
	private JRadioButton matrice5 = new JRadioButton("5x5");
	private LeftPanel leftPanel;

	public MatriceExemplePanel(LeftPanel pLeftPanel) {
		leftPanel = pLeftPanel;
		this.setLayout(new GridLayout(4, 1));

		// radio box!

		this.add(matrice3);
		this.add(matrice4);
		this.add(matrice5);

		// bouton valider
		NombreSommetValidateButton nombreSommetValidateButton = new NombreSommetValidateButton(
				this);
		this.add(nombreSommetValidateButton);

	}

	public void createMatrice() {
		if (matrice3.isSelected()) {
			leftPanel.createMatrice(3);
		} else if (matrice4.isSelected()) {
			leftPanel.createMatrice(4);
		} else if (matrice5.isSelected()) {
			leftPanel.createMatrice(5);
		}
	}

}
