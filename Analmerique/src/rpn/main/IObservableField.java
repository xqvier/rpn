package rpn.main;


public interface IObservableField {
	void addObservateur(IObservateurField obs);
	void updateObservateur(String value);
}
