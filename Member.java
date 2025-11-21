package projectCSC111;

public class Member {
	private int id;
	private String name;
	private int borrowedCount;
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;
	
	public static double TotalRevenue = 0.0;
	public static int TotalViewBorrowed = 0;
	public static int TotalBorrows = 0;
	public static int TotalReturns = 0;
	
	public Member(int id, String name, int borrowedCount)
	{
		this.id= id;
		this.name= name;
		this.borrowedCount= borrowedCount;
	}
	
	
	private boolean canBorrow()
	{
		return borrowedCount < 5;
	}
	
	
	private boolean canReturn()
	{
		return borrowedCount > 0;
	}
	
	
	public void viewBorrowedCount()
	{
		numViewBorrowed++;
		TotalViewBorrowed++;
		System.out.println("The number of current borrowed book is: "+ borrowedCount);
	}
	
	
	
	public boolean borrowOne()
	{
		if (canBorrow())
		{
		borrowedCount++;
		numBorrows++;
		sessionFees += 0.5;
		TotalRevenue += 0.5;
		TotalBorrows++;
		System.out.println("You borrowed a book successfully.\n Your fees increment \n      ---- +0.5 ----");
		return true;
		}
		
		else
		{
			System.out.println("You can't borrow more than 5 books.\nLeave books for others :)   and enjoy the books you own.");
			return false;
		}
	}
	
	
	
	public boolean returnOne()
	{
		if (canReturn())
		{
			borrowedCount--;
			numReturns++;
			TotalReturns++;
			System.out.println("You return a book successfully.\nThanks.  \ntake my heart. <3");
			return true;
		}
		
		else 
		{
			System.out.println("You can't return a book.\nYou don't have any one :)   go and borrow one, man.");
			return false;
		}
	}
	
	
	
	public void displayStatistics()
	{
		System.out.println("The Session statistics for "+ name + ", who has ID: (" + id +")   is: \n");
		System.out.println("The number of Borrowed books is: "+ numBorrows);
		System.out.println("The number of Returned books is: "+ numReturns);
		System.out.println("The number of times you view Borrowed Count  is: "+ numViewBorrowed);
		System.out.printf("Fees imposed is: %.2f\n", sessionFees);

	}
	
	
	
	public void reset()
	{
		borrowedCount=0;
		numViewBorrowed=0;
		numBorrows=0;
		numReturns=0;
		sessionFees=0.0;
	}
	
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name= name;
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id= id;
	}
	
	
	
	public int getBorrowedCount()
	{
		return borrowedCount;
	}
	
	public void setBorrowedCount(int borrowedCount)
	{
		this.borrowedCount= borrowedCount;
	}
	
	
	
	public double getSessionFees()
	{
		return sessionFees;
	}
	
	public void setSessionFees(double SessionFees)
	{
		this.sessionFees= sessionFees;
	}
	
	
	
}
