
public abstract class Animal implements Countable { // can never do a new instance of this class

	private int count;

	public void incrementCount() {
		count++;
	}

	@Override
	public void resetCount() {
		count = 0;
	}

	@Override
	public int getCount() {
		return count;
	}
}
