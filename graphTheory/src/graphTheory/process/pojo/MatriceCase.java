package graphTheory.process.pojo;

public class MatriceCase {

	private int value;

	private boolean enabled = true;

	public MatriceCase(int pValue) {
		setValue(pValue);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if (enabled) {
			return Integer.toString(value);
		} else {
			return "-" + Integer.toString(value);
		}
	}
}
