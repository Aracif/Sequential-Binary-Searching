package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
		//Only print menu once(save some paper)
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
					System.out.println("Items added");
					break;
				
				case 2: System.out.println("case 2");
				break;
				
				case 3: 
					String searchItem = r.readLine();
					int i = adt.search(searchItem);
					System.out.println(" " + i);
				break;
				
				case 4: 					
					adt.strings = new String[3];
					System.out.println("List Cleared");
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







