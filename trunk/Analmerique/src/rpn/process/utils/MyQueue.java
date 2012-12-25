package rpn.process.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;
import rpn.main.Params;

public class MyQueue<T> extends LinkedList<T> implements 
		IObservableList {

	
	private static final long serialVersionUID = 1L;

	ArrayList<IObservateurList> listObservateurs = new ArrayList<IObservateurList>();

	@Override
	public T poll() {
		T result = super.poll();
		updateObservateurRemove();
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public boolean add(T e) {
		boolean result = super.add(e);
		updateObservateurAdd(((Element) e).getValeur().toString());
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void clear() {
		super.clear();
		updateObservateurClear();
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addObservateur(IObservateurList obs) {
		this.listObservateurs.add(obs);
	}

	@Override
	public void updateObservateurRemove() {
		for (IObservateurList obs : listObservateurs) {
			obs.remove();
		}

	}

	@Override
	public void updateObservateurAdd(String value) {
		for (IObservateurList obs : listObservateurs) {
			obs.add(value);
		}

	}

	@Override
	public void updateObservateurClear() {
		for (IObservateurList obs : listObservateurs) {
			obs.clear();
		}
		
	}

}
