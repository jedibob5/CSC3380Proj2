public class DiscountCustomer extends Customer implements Comparable<DiscountCustomer>
{
	private double purchases;
	private int discount;
	
	/**
	 * returns the value of the customer's total purchases
	 * @return the customer's total purchases
	 */
	public double getPurchases()
	{
		return purchases;
	}
	
	/**
	 * sets the value of the customer's total purchases
	 * @param pur the desired value to set purchases
	 */
	public void setPurchases(double pur)
	{
		purchases = pur;
	}
	
	/**
	 * returns the customer's discount amount
	 * @return discount
	 */
	public double getDiscount()
	{
		return discount;
	}
	
	/**
	 * sets the customer's discount amount
	 * @param disc the value to set the discount
	 */
	public void setDiscount(int disc)
	{
		discount = disc;
	}
	
	/**
	 * Calculates the discount amount based upon the customer's total purchases
	 */
	public void calcDiscount()
	{
		if(purchases >= 1000.0)
			discount = 40;
		else if(purchases >= 750.0)
			discount = 35;
		else if(purchases >= 500.0)
			discount = 30;
		else if(purchases >= 200.0)
			discount = 25;
		else
			discount = 0;
	}
	
	/**
	 * Allows the customer's purchase amount to be compared with that of another DiscountCustomer object.
	 * Streamlines the selection sort algorithm in the linear list.
	 * This is an implementation of the compareTo interface.
	 */
	public int compareTo(DiscountCustomer other)
	{
		if(this.purchases > other.purchases)
			return 1;
		if(this.purchases < other.purchases)
			return -1;
		else
			return 0;
	}

}
