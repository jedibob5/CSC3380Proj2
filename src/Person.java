
public class Person 
{
	private String name;
	private String address;
	private long phone;
	
	/**
	 * returns person's name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * sets person's name
	 * @param n the name
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * returns person's address
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * sets person's address
	 * @param adr the address
	 */
	public void setAddress(String adr)
	{
		address = adr;
	}
	
	/**
	 * returns person's phone number
	 * @return phone number
	 */
	public long getPhone()
	{
		return phone;
	}
	
	/**
	 * sets person's phone number
	 * @param ph the phone number
	 */
	public void setPhone(long ph)
	{
		phone = ph;
	}
}
