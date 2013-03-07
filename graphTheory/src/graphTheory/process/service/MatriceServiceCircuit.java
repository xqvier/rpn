package graphTheory.process.service;

import graphTheory.process.param.Params;
import graphTheory.process.pojo.Matrice;
import graphTheory.ui.MainFrame;

public class MatriceServiceCircuit extends Thread {
	private Matrice matrice;
	private MainFrame mainFrame;

	public MatriceServiceCircuit(Matrice pMatrice, MainFrame pMainFrame) {
		matrice = pMatrice;
		mainFrame = pMainFrame;
	}
@Override
public void run() {

		boolean change = true;
		while (change) {
			change = false;
			for (int i = 0; i < matrice.getSize(); i++) {
				// si la ligne courante n'est pas déja barré et qu'elle
				// représente que des zéro
				if (!matrice.isThatLineDisabled(i)
						&& matrice.isThatLineFullOfZero(i)) {
					// on barre la ligne et la colonne
					matrice.disableColumn(i);
					matrice.disableLine(i);
					change = true;

					myWait();
				}
			}
		}

		if (matrice.getEnabledSize() != 0) {
			matrice.enableMatrice();
			mainFrame.thereIsCircuit(true);
		}
		matrice.enableMatrice();
		mainFrame.thereIsCircuit(false);
	}

	private void myWait() {

		if (Params.STEP_BY_STEP) {
			Params.WAIT = true;
			while (Params.WAIT)	;
		} else {
			try {
				Thread.sleep(Params.WAIT_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
