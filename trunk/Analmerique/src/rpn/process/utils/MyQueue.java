package rpn.process.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import rpn.main.IObservableList;
import rpn.main.IObservateurList;
import rpn.main.Params;

public class MyQueue<T> extends LinkedList<T> implements IMyList,
		IObservableList {

	private static final long serialVersionUID = 1L;

	ArrayList<IObservateurList> listObservateurs = new ArrayList<IObservateurList>();

	@Override
	public T poll() {
		T result = super.poll();
		updateObservateur(this);
		try {
			if (Params.STEP_BY_STEP) {
				myWait();
			} else {
				Thread.sleep(Params.WAIT_TIME);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public boolean add(T e) {
		boolean result = super.add(e);
		updateObservateur(this);
		try {
			if (Params.STEP_BY_STEP) {
				myWait();
			} else {
				Thread.sleep(Params.WAIT_TIME);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public void clear() {
		super.clear();
		updateObservateur(this);
		try {
			synchronized (this) {
				if (Params.STEP_BY_STEP) {
					myWait();
				} else {
					Thread.sleep(Params.WAIT_TIME);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addObservateur(IObservateurList obs) {
		this.listObservateurs.add(obs);
	}

	@Override
	public void updateObservateur(IMyList list) {
		for (IObservateurList obs : listObservateurs) {
			obs.update(list);
		}
	}

	private void myWait(){
		Params.WAIT = true;
		while(Params.WAIT);
		
	}
	
}
