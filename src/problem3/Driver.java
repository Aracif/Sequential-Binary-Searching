package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {

	//Get Menu Selection
	private static Integer getSelection(){
		Integer selection = null;		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		while(selection == null){
			try{		
				selection = Integer.parseInt(r.readLine());			
			}

			catch(NumberFormatException e){				
				System.out.println("NumberFormatException " + e.getMessage());
			}
			catch(IOException e){
				System.out.println("IOException " + e.getMessage());
			}
		}
		return selection;
	}


	public static void main(String[] args){
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader
		AscendinglyOrderedStringList adt = new AscendinglyOrderedStringList();

		
		System.out.println("\t 1. Insert specified item into list.");
		System.out.println("\t 2. Remove item in specified position in the list.");
		System.out.println("\t 3. Search list for specified item.");
		System.out.println("\t 4. Clear list.");
		System.out.println("\t 5. Display content of list.");

		while(true)
		{			
			try{
				switch(getSelection()){
				case 1: 
					String item = r.readLine();
					adt.add(item);
					System.out.println("Item was added");
					break;

				case 2: 
					System.out.println("Enter the index of the value you wish to remove ");
					Integer num = Integer.parseInt(r.readLine());				
					adt.remove(num);
					break;

				case 3: 
					String searchItem = r.readLine();
					Integer i = null;
					if(adt.numItems  == 0){
						System.out.println("Not found. Insert at position 0");
					}
					else{
						i = adt.search(searchItem);
						if(i>0){
							System.out.println("Found at position " + i);
						}
						else{
							System.out.println("Not found. Insert at position " + Math.abs(i));
						}
					}					
					break;

				case 4: 					
					adt.strings = new String[3];
					System.out.println("List Cleared");
					adt.numItems = 0;
					break;

				case 5: 
					System.out.println(adt);				
					break;
				}
			}

			catch(IOException e){
				System.out.println(e.getMessage());
			}
		}

	}
}







