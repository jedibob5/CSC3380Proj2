
public class Customer extends Person
{
	private boolean mailList;
	private String email;
	
	/**
	 * returns the mailing list status as a boolean
	 * @return
	 */
	public boolean mailListStatus()
	{
		return mailList;
	}
	
	/**
	 * returns the mailing list status as a string
	 * @return "Yes" if mailList == 1, "No" otherwise
	 */
	public String mailListString()
	{
		if(mailList)
			return "Yes";
		else
			return "No";
	}
	
	/**
	 * sets a customer's mailing list status
	 * @param ml desired status
	 */
	public void setMailList(boolean ml)
	{
		mailList = ml;
	}
	
	/**
	 * returns a customer's email address
	 * @return email address
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * sets a customer's email address
	 * @param e email address
	 */
	public void setEmail(String e)
	{
		email = e;
	}
	
	
	
}
