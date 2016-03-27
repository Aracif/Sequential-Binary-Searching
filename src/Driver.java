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

public class Driver {

	public static void main(String[] args) throws IOException {
		ListArrayBasedPlus listArrayChild = new ListArrayBasedPlus();
		BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));
		listArrayChild.add(0, -12);
		listArrayChild.add(0, 4);
		listArrayChild.add(0, 7);
		


		String currentLine;
		while ((currentLine = bRead.readLine().trim()) != null) {
			System.out.println("Select from the following menu: ");
			System.out.println("\t1. Insert item to list. ");
			System.out.println("\t2. Remove item from list.");
			System.out.println("\t3. Get item from list.");
			System.out.println("\t4  Search for a specified item in the list.");
			System.out.println("\t5. Clear list.");
			System.out.println("\t6. Print size and content of list.");
			System.out.println("\t7. Exit program.");
			
			Integer entryInt = Integer.parseInt(currentLine);
			System.out.println("Make your menu selection now: " + currentLine);

			switch (entryInt) {
			case 1:
				System.out.println("You are now inserting an item into the list.");
				Integer item = Integer.parseInt(bRead.readLine().trim());
				System.out.println("\tEnter item: " + item);
				String index = bRead.readLine().trim();
				System.out.println("\tEnter position to insert item in: " + index);
				Integer indexInt = Integer.parseInt(index);
				if ((indexInt >= 0 && indexInt <= ListArrayBasedPlus.numItems)
						&& (ListArrayBasedPlus.numItems != ListArrayBasedPlus.items.length)) {
					listArrayChild.add(indexInt, item);
					System.out.println("Item " + item + " inserted in position " + index + " in the list.\n");
					break;
				} else if ((ListArrayBasedPlus.items.length == ListArrayBasedPlus.numItems)) {
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
					Object currentObj = ListArrayBasedPlus.items[selectConvert];
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
				if (entInt > ListArrayBasedPlus.items.length - 1 || entInt < 0) {
					System.out.println("\nPosition specified is out of range.\n");
					break;
				} else {
					Object selectedObj = ListArrayBased.items[entInt];
					System.out.println("Item " + selectedObj + " retrieved from position " + entInt + " in list.");
					break;
				}

			case 4:
				Object searchItem = Integer.parseInt(bRead.readLine().trim());	
				Object currentItem;
				boolean exists = false;
				for(int i = 0; i<ListArrayBased.numItems && exists == false; i++){ 
					currentItem = listArrayChild.get(i);
					if(searchItem.equals(currentItem)){
						System.out.println("Found at index : " + i);
						exists = true;
					}
				}				
				if(exists == false){
					System.out.println("D.N.E");
				}
				break;

			case 5:
				listArrayChild.removeAll();
				System.out.println("\nLIST CLEARED\n");
				
				break;

			case 6:
				if (listArrayChild.isEmpty()) {
					System.out.println("\nList is Empty.\n");
				} else {
					System.out.println("\tList of size " + ListArrayBased.numItems + " has the following items : "
							+ listArrayChild + "\n");
				}
				break;

			case 7:
				System.out.println("\nGoodbye\n");
				System.exit(0);

			}
		}
	}
}