package graphTheory.ui.panel;

import graphTheory.ui.button.NombreSommetValidateButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// radio box!
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(matrice3);
		buttonGroup.add(matrice4);
		buttonGroup.add(matrice5);
		gbc.gridy = 0;		
		this.add(matrice3, gbc);
		gbc.gridy = 1;		
		this.add(matrice4, gbc);
		gbc.gridy = 2;		
		this.add(matrice5, gbc);

		// bouton valider
		NombreSommetValidateButton nombreSommetValidateButton = new NombreSommetValidateButton(
				this);
		gbc.gridy = 3;		
		this.add(nombreSommetValidateButton, gbc);

	}

	public void createMatrice() {
		if (matrice3.isSelected()) {
			leftPanel.createMatrice(3);
		} else if (matrice4.isSelected()) {
			leftPanel.createMatrice(4);
		} else if (matrice5.isSelected()) {
			leftPanel.createMatrice(5);
		}else {
			leftPanel.createMatrice();
		}
	}

}
