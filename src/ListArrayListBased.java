import java.util.ArrayList;

public class ListArrayListBased implements ListInterface {
	protected static ArrayList<Object> items;
	protected static int numItems;

	public ListArrayListBased() {
		items = new ArrayList<Object>();
		numItems = 0;
	}

	public boolean isEmpty() {
		return (numItems == 0);
	}

	public int size() {
		return numItems;
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index <= numItems) {
			items.add(index, item);
			numItems++;
		} else {
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on ADD");
		}
	}

	public Object get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems) {
			return items.get(index);
		} else {
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on GET");
		}
	}

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems) {
			items.remove(index);
			numItems--;
		} else {
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on REMOVE");
		}
	}

	public void removeAll() {
		items = new ArrayList<Object>();
		numItems = 0;
	}

}