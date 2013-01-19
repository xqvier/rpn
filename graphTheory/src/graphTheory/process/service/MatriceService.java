package graphTheory.process.service;

import graphTheory.process.param.Params;
import graphTheory.process.pojo.Matrice;

import java.util.ArrayList;

public class MatriceService extends Thread{
	
	public static boolean isThereAnyCircuit(Matrice matrice){
		boolean change = true;
		while (change){		
			change  = false;
			for(int i = 0 ; i< matrice.getSize(); i++){
				// si la ligne courante n'est pas déja barré et qu'elle représente que des zéro
				if(!matrice.isThatLineDisabled(i) && matrice.isThatLineFullOfZero(i)){
					// on barre la ligne et la colonne
					matrice.disableColumn(i);
					matrice.disableLine(i);
					change = true;
					
					myWait();
				}
			}
		}
		
		if(matrice.getEnabledSize() == 0){
			matrice.enableMatrice();
			return false;
		}
		matrice.enableMatrice();
		return true;
	}
	
	
	private static void myWait() {

		if(Params.STEP_BY_STEP){
			Params.WAIT = true;
			while(Params.WAIT);				
		} else {
			try {
				Thread.sleep(Params.WAIT_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	public static void calculateLevel(Matrice matrice, ArrayList<Integer> niveaux){
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

}
