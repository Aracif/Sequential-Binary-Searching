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
		int lo = 0;
		int high = numItems - 1;
		int mid = 0;
		int c = 0;
			while(lo<=high){
				mid =  (lo+high)/2;
				c = item.compareTo(strings[mid]);
				if(c < 0){
					high = mid - 1;
				}
				else if(c > 0){
					lo = mid + 1;
				}
				else{
					lo = Integer.MAX_VALUE;
				}				
			}
			if((mid == 0 && c >= 1) || (mid == numItems-1 && c >= 1)){
				mid++;
			}		
			return mid ;
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
