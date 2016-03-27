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
		int index = search(item);
		System.out.println("Insert index: " + index);
		String oldString = strings[index];
		if(numItems == strings.length || numItems + 1 == strings.length){
			resize();			
		}
		else{				
			for(int i = index+1; i<numItems; i++){
				strings[i+1] = strings[i];
			}		
		}
		strings[index] = item;
		strings[index + 1] = oldString;
		numItems++;
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
		String currentString = strings[0];
		System.out.println("search");
		int posi = 0;
		for(int i = 1; i <= numItems; i++){
			int orderVal = currentString.compareTo(item);
			System.out.println("Compare To Value : " + orderVal);
			if(orderVal < 0){
				currentString = strings[i];
			}
			else if(orderVal >= 0){
				posi = i - 1 ;
				
			}
		}
		return posi;
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
