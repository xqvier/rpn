package graphTheory.ui.panel;

import graphTheory.process.pojo.Matrice;

import javax.swing.JProgressBar;

public class CalculBar extends JProgressBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculBar() {
		super(0, 100);
	}

	public void setMatrice(Matrice matrice) {
		matrice.addObservateur(new IObservateurMatrice() {

			@Override
			public void update(Matrice matrice) {
				CalculBar.this.setValue(matrice.getSize()
						* matrice.getEnabledSize() / 100);

			}
		});
	}
}
