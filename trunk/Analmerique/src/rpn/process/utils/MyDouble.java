package rpn.process.utils;

import java.util.ArrayList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;

public class MyDouble extends Number implements IObservableList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double value;
	private ArrayList<IObservateurList> listIObservateur = new ArrayList<IObservateurList>();
	
	@Override
	public void addObservateur(IObservateurList obs) {
		listIObservateur.add(obs);
	}

	@Override
	public void updateObservateurAdd(String value) {
		for(IObservateurList obs : listIObservateur){
			obs.add(value);
		}
	}

	@Override
	public void updateObservateurRemove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObservateurClear() {
		// TODO Auto-generated method stub

	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		updateObservateurAdd(Double.toString(value));
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}

}
