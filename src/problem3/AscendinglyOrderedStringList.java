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

	public void add(String item)
	{
		int index = 0;
		if(numItems!=0)
		{
			if(numItems + 1 >= strings.length)
			{
				resize();
			}			
			index = search(item);		
			for(int i = numItems; i>index; i--)
			{
				strings[i] = strings[i-1];
			}
		}
		numItems++;
		strings[index] = item;
	}

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
		int start = 0;
		int end = numItems - 1;
		int mid = 0;
		boolean notFound = true;
		int iteration = 0;
		try{
			while(notFound && numItems/2 >= iteration){
				mid = start + (end - start)/2;
				int c = item.compareTo(strings[mid]);
				if(c < 0){
					end = mid - 1;
				}
				else if(c > 0){
					start = mid + 1;
				}
				else{
					notFound = false;
				}
				iteration++;
			}
			if(end == mid && notFound == true){
				mid++;
			}
			return mid ;
		}
		catch(NullPointerException e){
			return mid;
		}
	}



	//private resize method
	private void resize(){
		String[] temp = new String[strings.length + strings.length/2 + 1];
		for(int i = 0; i<strings.length; i++){
			temp[i] = strings[i];
		}
		strings = temp;
		System.out.println(this);
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
