package rpn.process.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;

public class MyQueue<T> extends LinkedList<T> implements IMyList,
		IObservableList {

	private static final long serialVersionUID = 1L;

	ArrayList<IObservateurList> listObservateurs = new ArrayList<IObservateurList>();

	@Override
	public T poll() {
		T result = super.poll();
		updateObservateurRemove();
		return result;

	}

	@Override
	public boolean add(T e) {
		boolean result = super.add(e);
		updateObservateurAdd(((Element) e).getValeur().toString());
		return result;
	}
	
	@Override
	public void clear() {
		super.clear();
		updateObservateurClear();
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
