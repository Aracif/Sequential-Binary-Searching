import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/03/16
 * Submitted:  02/04/16
 * Comment: test suite and sample run attached
 * @author: Sal Ficara
 * @version: 2016.03.02
 */

public class ProblemOneDriver {

	public static void main(String[] args) throws IOException {
		ListArrayBasedPlusPlus listArrayChild = new ListArrayBasedPlusPlus();
		BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));
		String currentLine;
		listArrayChild.add(0, "a");
		listArrayChild.add(1, "b");
		listArrayChild.add(2, "c");
		while ((currentLine = bRead.readLine().trim()) != null) {
			System.out.println("Select from the following menu: ");
			System.out.println("\t1. Insert item to list. ");
			System.out.println("\t2. Remove item from list.");
			System.out.println("\t3. Get item from list.");
			System.out.println("\t4. Clear list.");
			System.out.println("\t5. Print size and content of list.");
			System.out.println("\t6. Reverse list.");
			System.out.println("\t7. Check if list is even.");
			System.out.println("\t8. Make the array an exact fit.");
			System.out.println("\t9. Randomize array items.");
			System.out.println("\t10. Exit program.");
			
			Integer entryInt = Integer.parseInt(currentLine);
			System.out.println("Make your menu selection now: " + currentLine);

			switch (entryInt) {
			case 1:
				System.out.println("You are now inserting an item into the list.");
				String item = bRead.readLine().trim();
				System.out.println("\tEnter item: " + item);
				String index = bRead.readLine().trim();
				System.out.println("\tEnter position to insert item in: " + index);
				Integer indexInt = Integer.parseInt(index);
				if ((indexInt >= 0 && indexInt <= listArrayChild.numItems)
						&& (listArrayChild.numItems != listArrayChild.items.length)) {
					listArrayChild.add(indexInt, item);
					System.out.println("Item " + item + " inserted in position " + index + " in the list.\n");
					break;
				} else if ((listArrayChild.items.length == listArrayChild.numItems)) {
					listArrayChild.resize(indexInt, item);
					System.out.println("Item " + item + " inserted in position " + index + " in the list.\n");
					break;
				} else {
					System.out.println("Position specified is out of range!");
					break;
				}

			case 2:
				String selection = bRead.readLine().trim();
				System.out.println("Enter position to remove item from: " + selection);
				Integer selectConvert = Integer.parseInt(selection);

				if (selectConvert >= 0 && selectConvert <= ListArrayBased.numItems - 1) {
					Object currentObj = listArrayChild.items[selectConvert];
					listArrayChild.remove(selectConvert);
					System.out.println("\nItem " + currentObj + " remove from position " + selectConvert);
					break;

				} else {
					System.out.println("\nPosition specified is out of range.\n");
				}
				break;

			case 3:
				String ent = bRead.readLine().trim();
				System.out.println("\tEnter position to retrieve item from :" + ent);
				Integer entInt = Integer.parseInt(ent);
				if (entInt > listArrayChild.items.length - 1 || entInt < 0) {
					System.out.println("\nPosition specified is out of range.\n");
					break;
				} else {
					Object selectedObj = listArrayChild.items[entInt];
					System.out.println("Item " + selectedObj + " retrieved from position " + entInt + " in list.");
					break;
				}

			case 4:
				listArrayChild.removeAll();
				System.out.println("\nLIST CLEARED\n");
				break;

			case 5:
				if (listArrayChild.isEmpty()) {
					System.out.println("\nList is Empty.\n");
				} else {
					System.out.println("\tList of size " + ListArrayBased.numItems + " has the following items : "
							+ listArrayChild + "\n");
				}
				break;

			case 6:
				listArrayChild.reverse();
				break;

			case 7:
				if(listArrayChild.isEven()){
					System.out.println("This list contains an even number of items.");
					break;
				}
				else{
					System.out.println("This list contains an odd number of items.");
					break;
				}
			case 8:
				System.out.println("Current array size: " + listArrayChild.items.length);
				System.out.println("Non-null positions: " + listArrayChild.numItems);
				listArrayChild.exactFit();
				System.out.println("New Current array size: " + listArrayChild.items.length);
				System.out.println("Non-null positions: " + listArrayChild.numItems);
				break;
			case 9:
				listArrayChild.randomizeOrder();
				break;
			case 10:
				System.out.println("\nGoodbye\n");
				System.exit(0);

			}
		}
	}
}