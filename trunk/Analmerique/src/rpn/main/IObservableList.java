package rpn.main;

import rpn.process.utils.IMyList;

public interface IObservableList {
	void addObservateur(IObservateurList obs);
	void updateObservateur(IMyList list);
}
