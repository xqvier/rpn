package graphTheory.process.pojo;

import graphTheory.ui.panel.IObservateurLevels;

import java.util.ArrayList;

public class Levels extends ArrayList<Integer> implements IObservableLevels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<IObservateurLevels> listObservateurLevels = new ArrayList<IObservateurLevels>();
	private int size;
	public Levels(int pSize) {
		size = pSize;
		for(int i = 0 ; i < size; i++){
			this.add(0);
		}
	}

	@Override
	public void addObservateur(IObservateurLevels obs) {
		listObservateurLevels.add(obs);
		
	}

	@Override
	public void updateObservateur() {
		for(IObservateurLevels obs : listObservateurLevels){
			obs.update();
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Integer set(int index, Integer element) {
		element = super.set(index, element);
		updateObservateur();
		return element;
	}

}
