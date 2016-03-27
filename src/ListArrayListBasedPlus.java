
import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased {

	public ListArrayListBasedPlus() {
		super();
	}

	public void resize(int newSize) {
		ArrayList<Object> temp = new ArrayList<Object>(newSize);
		for (int i = 0; i < items.size(); i++) {
			Object currentObj = items.get(i);
			temp.add(currentObj);
		}
		items = temp;
	}

	public void reverse() {
		int arraySize = items.size() - 1;
		ArrayList<Object> temp = new ArrayList<Object>();
		for (int index = 0; index < items.size(); index++) {
			Object currentObj = items.get(arraySize);
			temp.add(index, currentObj);
			arraySize--;
		}
		items = new ArrayList<Object>(temp);
	}

	public String toString() {
		String strOutput = "";
		for (int i = 0; i < items.size(); i++) {
			strOutput += "\n" + items.get(i) + " at index " + i;
		}
		return strOutput;
	}

}