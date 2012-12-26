package rpn.process.utils;

import java.util.ArrayList;

import rpn.main.IObservableField;
import rpn.main.IObservateurField;

public class MyDouble extends Number implements IObservableField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double value;
	private ArrayList<IObservateurField> listIObservateur = new ArrayList<IObservateurField>();

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		updateObservateur(Double.toString(value));
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

	@Override
	public void updateObservateur(String value) {
		for(IObservateurField obs : listIObservateur){
			obs.update(value);
		}
	}

	@Override
	public void addObservateur(IObservateurField obs) {
		listIObservateur.add(obs);
	}

}
