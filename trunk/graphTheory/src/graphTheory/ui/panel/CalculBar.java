package graphTheory.ui.panel;

import java.awt.Dimension;

import graphTheory.process.pojo.Matrice;

import javax.swing.JProgressBar;

public class CalculBar extends JProgressBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Matrice matrice;
	
	public CalculBar() {
		super(0, 100);
		this.setPreferredSize(new Dimension(200, 30));
	}

	public void setMatrice(Matrice pMatrice) {
		this.matrice = pMatrice;
		matrice.addObservateur(new IObservateurMatrice() {

			@Override
			public void update(Matrice matrice) {
				myDraw();
			}


		});
	}
	private void myDraw() {
		setValue(100 - (matrice.getEnabledSize()
				*100 / matrice.getSize()  ));
		validate();		
	}
}
