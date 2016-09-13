/****************************************************************/
/* 		  	 		Mon Cher Spa Discount System  				*/
/*			   			Robert Anderson							*/
/* 		  			  CSC 3380_03 Section 1       				*/
/*           		     Assignment 2              				*/
/* Instructor: Douglas  	   		  							*/
/* Program due date:  February 18, 2016      					*/
/*																*/
/* Problem Specification: To read a customer information file,  */
/* calculate each customer's discount based on their total		*/
/* purchases for the month, then log them to an output file in	*/
/* ascending order of total purchase amounts					*/
/* 																*/
/* Problem Analysis: To solve the problem, the program takes	*/
/* a text file containing customer information as input, parses	*/
/* it into an array-based list ADT, uses selection sort to		*/
/* arrange by total purchases, then prints to another text file	*/
/* as output.													*/
/*																*/
/* Implementation Directions: Place the Main.java, Person.java,	*/
/* Customer.java, DiscountCustomer.java, and LinearList.java in */
/* a directory along with an input file titled MonCher.data.	*/
/* Compile all of the .java source code files, then execute		*/
/* Main.java.													*/
/****************************************************************/
import java.util.*;
import java.io.*;


public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File input = new File("MonCher.data");
		LinearList customerList = loadCustList(input);
		customerList.selectionSort();
		reportOutput(customerList);

		System.out.println("Operations complete. Output logged to \"Report.out.\"");
	}

	/**
	 * Parses customer data from the input file into a linear list ADT.
	 * @param input the File object to be used as input
	 * @return a linear list ADT containing the customer records from the input file.
	 * @throws FileNotFoundException
	 */
	public static LinearList loadCustList(File input) throws FileNotFoundException
	{
		Scanner fileReader = new Scanner(input);
		LinearList custList = new LinearList(20);
		while(fileReader.hasNext())
		{
			DiscountCustomer custEntry = new DiscountCustomer();
			custEntry.setName(fileReader.nextLine());
			custEntry.setAddress(fileReader.nextLine());
			custEntry.setPhone(fileReader.nextLong());
			fileReader.nextLine();								//consumes end of line character
			if(fileReader.nextInt() == 1)
				custEntry.setMailList(true);
			else
				custEntry.setMailList(false);
			custEntry.setEmail(fileReader.next());
			fileReader.nextLine();

			/* Ensures purchase is properly parsed as a double if given with a $ sign in the input file */
			String purchases = fileReader.nextLine();
			if(purchases.charAt(0) == '$')
				purchases = purchases.substring(1);
			custEntry.setPurchases(Double.parseDouble(purchases));

			custEntry.calcDiscount();
			custList.insert(custEntry);
		}
		fileReader.close();
		return custList;
	}

	/**
	 * Reports the contents of the customer record list into an output file.
	 * @param cList the list containing the customer records
	 * @throws FileNotFoundException
	 */
	public static void reportOutput(LinearList cList) throws FileNotFoundException
	{
		PrintStream outWriter = new PrintStream("Report.out");
		outWriter.println("Mon Cher Boutique Customers by Purchase Amounts");
		outWriter.printf("%n%-21s%-21s%-12s%-15s%-21s%-18s%-10s%n", "Name", "Address", "Phone", "Mailing List", "Email", "Total Purchases", "Discount");
		cList.setCursor(0);
		for(int i = 0; i < cList.getLength(); i++)
		{
			outWriter.printf("%-21s%-21s%-12d%-15s%-21s%-18s%-10s%n", cList.pull().getName(),
					cList.pull().getAddress(), cList.pull().getPhone(), cList.pull().mailListString(),
					cList.pull().getEmail(), "$" + cList.pull().getPurchases(), cList.pull().getDiscount() + "%");
			cList.traverse();
		}
		outWriter.close();
	}
}
