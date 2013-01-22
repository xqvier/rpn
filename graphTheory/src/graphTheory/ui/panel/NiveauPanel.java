package graphTheory.ui.panel;

import graphTheory.process.pojo.Levels;
import graphTheory.ui.param.Params;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class NiveauPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Levels levels;

	public NiveauPanel() {
	}

	public void setLevels(Levels pLevels) {
		levels = pLevels;

		levels.addObservateur(new IObservateurLevels() {

			@Override
			public void update() {
				myDraw();
			}
		});
		myDraw();

	}

	private void myDraw() {
		this.removeAll();
		this.setPreferredSize(new Dimension((levels.size() + 1)
				* Params.SIZE_CASE_MATRICE, Params.SIZE_CASE_MATRICE));
		this.setLayout(new GridLayout(1, levels.size() + 1));
		JTextField textArea = new JTextField("LVL");
		textArea.setHorizontalAlignment(JTextField.CENTER);
		textArea.setFont(new Font(null, 0, 25));
		textArea.setEditable(false);
		this.add(textArea);
		for (int i = 0; i< levels.size() ; i++) {
			textArea = new JTextField(Integer.toString(levels.get(i)));
			textArea.setHorizontalAlignment(JTextField.CENTER);
			textArea.setFont(new Font(null, 0, 25));
			textArea.setEditable(false);
			this.add(textArea);
		}

		this.validate();

	}
}
