package problem2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 03/27/16
 * Submitted:  03/27/16
 * Comment: test suite and sample run attached
 * @author: Sal Ficara
 * @version: 2016.03.02
 */

public class Driver {
	
	private static Integer search(Integer searchItem, ListArrayListBasedPlus listArrayChild) throws NumberFormatException, IOException{			
		for(Integer i = 0; i<ListArrayListBased.numItems; i++){
			Integer currentItem = (Integer)listArrayChild.get(i);
			
			if(searchItem.equals(currentItem)){
				System.out.println("Found at index : " + (i));
				return i;
			}
			else if(searchItem<currentItem){
				System.out.println("D.N.E, can be inserted at position " + i);
				return -i-1;
			}
		}
		System.out.println("D.N.E, can be inserted at position " + ListArrayListBased.numItems);
		return -ListArrayListBased.numItems-1;
	}

	public static void main(String[] args) throws IOException {
		ListArrayListBasedPlus listArrayChild = new ListArrayListBasedPlus();
		BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));
		listArrayChild.add(0, -12);
		listArrayChild.add(1, 4);
		listArrayChild.add(2, 7);



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
				System.out.println("Enter a value : ");
				Integer searchKey = Integer.parseInt(bRead.readLine().trim());
				Integer position = search(searchKey, listArrayChild);
				if(position>0){
					System.out.println("Already in the list @ position " + position);
				}
				else{
					System.out.println("New item inserted @ position " + (-position-1));
					listArrayChild.add(-position-1, searchKey);
				}
				break;



			case 2:
				String selection = bRead.readLine().trim();
				System.out.println("Enter position to remove item from: " + selection);
				Integer selectConvert = Integer.parseInt(selection);

				if (selectConvert >= 0 && selectConvert <= ListArrayListBased.numItems - 1) {
					Object currentObj = listArrayChild.get(selectConvert);
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
				if (entInt > ListArrayListBasedPlus.items.size() - 1 || entInt < 0) {
					System.out.println("\nPosition specified is out of range.\n");
					break;
				} else {
					Object selectedObj = ListArrayListBased.items.get(entInt);
					System.out.println("Item " + selectedObj + " retrieved from position " + entInt + " in list.");
					break;
				}

			case 4:
				Integer i = search(Integer.parseInt(bRead.readLine().trim()),listArrayChild);
				System.out.println("num" + i);
				break;

			case 5:
				listArrayChild.removeAll();
				System.out.println("\nLIST CLEARED\n");

				break;

			case 6:
				if (listArrayChild.isEmpty()) {
					System.out.println("\nList is Empty.\n");
				} else {
					System.out.println("\tList of size " + ListArrayListBased.numItems + " has the following items : "
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