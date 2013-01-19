package graphTheory.process.pojo;

import graphTheory.ui.panel.IObservateurMatrice;

import java.util.ArrayList;

public class Matrice implements IObservableMatrice {
	

	ArrayList<IObservateurMatrice> listObservateurs = new ArrayList<IObservateurMatrice>();
	
	private ArrayList<ArrayList<MatriceCase>> caseList = new ArrayList<ArrayList<MatriceCase>>();

	public Matrice(int size){
		for(int i = 0 ; i < size ; i ++){
			ArrayList<MatriceCase> column = new ArrayList<MatriceCase>();
			for(int j = 0 ; j < size ; j++){
				column.add(new MatriceCase(0));
			}
			caseList.add(column);
		}
		updateObservateur();
	}
	
	
	public ArrayList<ArrayList<MatriceCase>> getCaseList() {
		return caseList;
	}

	public void setCaseList(ArrayList<ArrayList<MatriceCase>> caseList) {
		this.caseList = caseList;
	}

	public void enableMatrice() {
		for (ArrayList<MatriceCase> column : caseList) {
			for (MatriceCase casee : column) {
				casee.setEnabled(true);
			}
		}

		updateObservateur();
	}

	public void disableLine(int line) {
		for (ArrayList<MatriceCase> column : caseList) {
			column.get(line).setEnabled(false);
		}

		updateObservateur();

	}

	public void disableColumn(int column) {
		for (MatriceCase casee : caseList.get(column)) {
			casee.setEnabled(false);
		}

		updateObservateur();
	}

	public boolean isThatLineFullOfZero(int line) {
		for (ArrayList<MatriceCase> column : caseList) {
			if (column.get(line).isEnabled() && column.get(line).getValue() == 1) {
				return false;
			}
		}
		return true;
	}

	public boolean isThatColumnFullOfZero(int column) {
		for(MatriceCase casee : caseList.get(column)) {
			if(casee.isEnabled() && casee.getValue() == 1){
				return false;
			}
		}
		return true;
	}
	
	public int getSize(){
		return caseList.size();
	}
	
	public int getEnabledSize(){
		int size = 0;
		for(int i = 0 ; i < getSize(); i++){
			if(!isThatLineDisabled(i)){
				size++;
			}
		}
		return size;
	}
	
	public boolean isThatLineDisabled(int line){
		for (ArrayList<MatriceCase> column : caseList) {
			if (column.get(line).isEnabled()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isThatColumnDisabled(int column){
		for(MatriceCase casee : caseList.get(column)) {
			if(casee.isEnabled()){
				return false;
			}
		}
		return true;
	}
	       
	
	@Override
	public String toString() {
		return caseList.toString();
	}


	@Override
	public void addObservateur(IObservateurMatrice obs) {
		listObservateurs.add(obs);
	}


	@Override
	public void updateObservateur() {
		for(IObservateurMatrice obs : listObservateurs){
			obs.update(this);
		}
		
	}

}
