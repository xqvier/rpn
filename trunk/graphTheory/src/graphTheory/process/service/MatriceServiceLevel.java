package graphTheory.process.service;

import graphTheory.process.param.Params;
import graphTheory.process.pojo.Levels;
import graphTheory.process.pojo.Matrice;

import java.util.ArrayList;

public class MatriceServiceLevel extends Thread {

	private Matrice matrice;
	private Levels niveaux;
	
	
	public MatriceServiceLevel(Matrice pMatrice, Levels pNiveaux) {
		matrice = pMatrice;
		niveaux = pNiveaux;
				
	}
	@Override
	public void run() {
			Integer level = 0;
			ArrayList<Integer> columnForThisLevel = null ;
			while(matrice.getEnabledSize()> 0){
				columnForThisLevel = new ArrayList<Integer>();
				for(int i = 0 ; i <matrice.getSize() ; i++){
					if(!matrice.isThatColumnDisabled(i) && matrice.isThatColumnFullOfZero(i)){
						columnForThisLevel.add(i);
						matrice.disableColumn(i);
						niveaux.set(i, level);
						myWait();
					}
				}
				for(Integer column : columnForThisLevel){
					matrice.disableLine(column);
					myWait();
				}
				level++;
			}

			matrice.enableMatrice();
	}
	
	private void myWait() {

		if(Params.STEP_BY_STEP){
			Params.WAIT = true;
			while(Params.WAIT);				
		} else {
			try {
				Thread.sleep(Params.WAIT_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
