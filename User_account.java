package system;

import java.util.*;

public class User_account {
	
	String username,password,name,phone, Adhaar_number;
	Date date;
	double balance;
	ArrayList<String> transactions ;
	User_account(String name,String phone,String Adhaar_number,String username,String password,Double balance,Date date)
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.Adhaar_number = Adhaar_number;
		this.date = date;
		this.balance = balance;
		transactions = new ArrayList<String>(5);
		transactions.add(String.format("Initial deposit : "+this.balance));
	}
	

	public void deposit(double amount,Date date)
	{
		balance+=amount;
		transactions.add(String.format("Amount deposited : "+amount));
	}
	public void withdraw(double amount,Date date)
	{
		if(amount > this.balance || this.balance-amount < 500)
		{
			System.out.println("Insufficient balance!");
			System.out.println("Your current account balance: "+this.balance);
		}
		else
		{
			balance-=amount;
			transactions.add(String.format("Amount withdrew : "+amount));
		}
	}
}
