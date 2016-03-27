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
			
			//Insert a value into its correct position following a ascending order format
			//This method eagerly advances to the next value if the searchKey > currentKey
			case 1:
				System.out.println("Enter a value : ");
				Integer searchKey = Integer.parseInt(bRead.readLine().trim());  //Value to search for
				Integer currentKey = (Integer)listArrayChild.get(0);			//Get first key for init. equality test
				boolean added = false;											//So we know when to stop
				try{
					for(int i = 1; i<ListArrayListBased.numItems+1 && added==false; i++){					
						if(searchKey>currentKey)	    //Eagerly advance if true
						{
							currentKey = (Integer)listArrayChild.get(i);
						}
						else if(searchKey<=currentKey)  //Add value if true then stop
						{
							listArrayChild.add(i-1, searchKey);
							added=true;					//Exit method
						}
					}
				}
				catch(ListIndexOutOfBoundsException e) //If we reach max index, add the searchKey to the last index.
				{
					listArrayChild.add(ListArrayListBased.numItems, searchKey);
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
				Object searchItem = Integer.parseInt(bRead.readLine().trim());	
				Object currentItem;
				boolean exists = false;
				for(int i = 0; i<ListArrayListBased.numItems && exists == false; i++){ 
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