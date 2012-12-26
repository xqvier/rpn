package rpn.process.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;
import rpn.main.Params;

public class MyStack<T> extends ArrayDeque<T> implements IMyList,
		IObservableList {

	private static final long serialVersionUID = 1L;

	ArrayList<IObservateurList> listObservateurs = new ArrayList<IObservateurList>();

	@Override
	public synchronized boolean add(T e) {

		boolean result = super.add(e);
		updateObservateur(this);
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void push(T e) {
		super.push(e);
		updateObservateur(this);
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public synchronized T pop() {
		T result = super.pop();
		updateObservateur(this);
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void clear() {
		super.clear();
		updateObservateur(this);
		try {
			Thread.sleep(Params.WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addObservateur(IObservateurList obs) {
		listObservateurs.add(obs);
	}


	@Override
	public void updateObservateur(IMyList list) {
		for (IObservateurList obs : listObservateurs) {
			obs.update(list);
		}
	}

}
