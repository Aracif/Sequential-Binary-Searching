package problem3;

public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface  {
	protected String[] strings = new String[3];
	protected int numItems;

	public AscendinglyOrderedStringList(){
		numItems = 0;
	}

	public boolean isEmpty(){
		return (numItems>0);
	}

	public int size(){
		return numItems;
	}

		public void add(String item){
			int index = 0;
			if(numItems >=1){
				index = search(item);
				System.out.println("Index" + index);			
				if(numItems == strings.length || numItems == strings.length + 1){
					resize();
					
				}			
		
				else if(index>=0 && index < strings.length ){					
					for(int i = numItems-1; i>=index; i--){
						strings[i+1] = strings[i];
					}
				}
			}
	
			strings[index] = item;
			numItems++;
		}
		
//	public void add(String item){
//		int index = 0;
//		if(numItems>=1){
//			index = search(item);
//		}
//
//		if(numItems == strings.length || numItems == strings.length + 1){
//			resize();
//		}			
//
//
//
//		for(int i = index -1; i<numItems; i++)
//			strings[i+1] = strings[i];
//
//
//
//
//		strings[index] = item;
//		numItems++;
//	}

	public void remove(int index)throws ListIndexOutOfBoundsException{


		if (index >= 0 && index < numItems)
		{
			for(int i = index + 1; i<numItems; i++){
				strings[i - 1] = strings[i]; 
			}
			numItems--;
			strings[numItems] = null;
		}
		else

		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on remove");
		}  // end if
	}


	public String get(int index) throws ListIndexOutOfBoundsException{    

		if (index >= 0 && index < numItems)
		{
			return strings[index];
		}
		else
		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on get");
		}  // end if
	} // end get



	public int search(String item){	
		//String[] s = new String[]{"c"};
		int start = 0;
		//numItems = 1;
		int end = numItems - 1;
		int mid = 0;
		boolean notFound = true;
		int iteration = 0;
		while(notFound && numItems/2 >= iteration){
			//System.out.println("loop");
			mid = start + (end - start)/2;
			int c = item.compareTo(strings[mid]);
			if(c < 0){
				end = mid - 1;
			}
			else if(c > 0){
				start = mid + 1;
			}
			else{
				//System.out.println("found " + mid);
				notFound = false;
			}
			iteration++;
		}
		if(end == mid && notFound == true){
			mid++;
		}


		return mid ;
	}



	//PRIVATE resize method
	private void resize(){
		String[] temp = new String[strings.length + strings.length/2 + 1];
		for(int i = 0; i<strings.length; i++){
			temp[i] = strings[i];
		}
		strings = temp;
		System.out.println(this);
		System.out.println(strings.length+ " ");
		System.out.println("resize");
	}

	public String toString()
	{
		String s = "";
		for(int i =0; i<numItems; i++){			
			s += strings[i] + " ";
		}
		return s;
	}



}
