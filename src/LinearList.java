/* 
 * Code is taken from my Project 1 submission, modified for the current assignment.
 * The generic-typed array workaround was removed, and the selectionSort and
 * swap methods were added.
 */
public class LinearList {
	
	private DiscountCustomer[] array;
	private int currentLength;
	private int cursor;

	/**
	 * Creates a new array-based linear list of given size.
	 * @param size size of the array to be created
	 */
	public LinearList(int size) {
		array = new DiscountCustomer[size];
		currentLength = 0;
		cursor = 0;
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param element the element to be added
	 */
	public void insert(DiscountCustomer element) {
		array[currentLength] = element;
		currentLength++;
	}
	
	/**
	 * returns the element at the cursor's position
	 * @return
	 */
	public DiscountCustomer pull() {
		return array[cursor];
	}
	
	/**
	 * Deletes the item at the cursor and shifts further elements back to fill the space
	 */
	public void delete() {
		for(int i = cursor; i < currentLength; i++) {
			array[i] = array[i + 1];
		}
		currentLength--;
	}
	
	/**
	 * Moves the cursor to the next position in the array. If at the end of the array,
	 * returns to the beginning.
	 */
	public void traverse() {
		if(cursor != currentLength - 1)
			cursor++;
		else
			cursor = 0;
	}
	
	/**
	 * Returns the current length of the array
	 * @return currentLength
	 */
	public int getLength() {
		return currentLength;
	}
	
	/**
	 * Returns the current cursor position
	 * @return the current position
	 */
	public int getCursor() {
		return cursor;
	}
	
	/**
	 * Sets the cursor position
	 * @param c the desired position
	 */
	public void setCursor(int c) {
		cursor = c;
	}
	
	/**
	 * Uses selection sort to sort the array in descending order.
	 */
	public void selectionSort()
	{
		
		for(int i = 0; i < currentLength; i++)
		{
			int currentMax = i;
			for(int j = i+1; j < currentLength; j++)
			{
				if(array[j].compareTo(array[currentMax]) == 1)
					currentMax = j;
			}
			if(i != currentMax)
				swap(i, currentMax);
		}
	}
	
	/**
	 * Swaps two elements of the array.
	 * @param index1 index of first element
	 * @param index2 index of second element
	 */
	public void swap(int index1, int index2)
	{
		DiscountCustomer temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
