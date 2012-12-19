package rpn.main;

public interface IObservableList {
	void addObservateur(IObservateurList obs);
	void updateObservateurAdd(String value);
	void updateObservateurRemove();
	void updateObservateurClear();
}
