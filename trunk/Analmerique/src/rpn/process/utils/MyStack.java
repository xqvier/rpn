package rpn.process.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;

public class MyStack<T> extends ArrayDeque<T> implements IMyList,
		IObservableList {

	private static final long serialVersionUID = 1L;

	ArrayList<IObservateurList> listObservateurs = new ArrayList<IObservateurList>();

	@Override
	public synchronized boolean add(T e) {

		boolean result = super.add(e);
		updateObservateurAdd(((Element) e).getValeur().toString());
		return result;
	}
	
	@Override
	public void push(T e) {
		super.push(e);
		updateObservateurAdd(((Element) e).getValeur().toString());
	}

	@Override
	public synchronized T pop() {
		T result = super.pop();
		updateObservateurRemove();
		return result;
	}

	@Override
	public void clear() {
		super.clear();
		updateObservateurClear();
	}
	
	@Override
	public void addObservateur(IObservateurList obs) {
		listObservateurs.add(obs);
	}

	@Override
	public void updateObservateurAdd(String value) {
		for (IObservateurList obs : listObservateurs) {
			obs.add(value);
		}
	}

	@Override
	public void updateObservateurRemove() {
		for (IObservateurList obs : listObservateurs) {
			obs.remove();
		}
	}

	@Override
	public void updateObservateurClear() {
		for (IObservateurList obs : listObservateurs) {
			obs.clear();
		}
	}

}
