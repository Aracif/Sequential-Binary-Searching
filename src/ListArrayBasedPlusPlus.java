import java.util.Random;

public class ListArrayBasedPlusPlus extends ListArrayBasedPlus {
	private Random ranInt;
	
	public ListArrayBasedPlusPlus(){
		ranInt = new Random();
	}
	
	public boolean isEven(){
		
		return (numItems%2==0);//returns true if array contains even number of items
	}
	
	public void exactFit(){
		//after your're completely done adding to array reduce its size to min
		//in order to save a little memory.
		Object temp[] = new Object[numItems];
		for(int i = 0; i<numItems; i++){
			temp[i] = items[i];
		}
		items = temp;
	}
	
	public void randomizeOrder(){
		//Take items in array and randomize their index
		//potentially useful to scramble sensitive info that may be 
		//stored in the array.
		Object temp[] = new Object[numItems];
		int endLoop = numItems;
		int tempItems = 0;
		int i = 0;
		while(tempItems != endLoop){
			int currentRandomNumber = ranInt.nextInt(items.length);	
			Object currentRanObject = items[currentRandomNumber];
			if(currentRanObject!=null){
				temp[i] = items[currentRandomNumber];
				super.remove(currentRandomNumber);
				tempItems++;
				i++;
			}
		}
		items = temp;
		numItems = endLoop;
	}
}