package system;

import java.util.*;

public class Bank {
	
	
	HashMap<String,User_account> stored;
	Bank()
	{
		stored = new HashMap<String,User_account>();
	}
	public static void main(String[] args)
	{
		int choice = 0;
		int ch=0;
		String yes = new String("yes");
		String username,password;
		double amount;
		User_account customer ;
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
  start:do {
			
				System.out.println("----------------------------");
				System.out.println("Welcome to Bank of Samruddhi");
				System.out.println("----------------------------");
				System.out.println("*MENU*");
				System.out.println("1.Register a savings account");
				System.out.println("2.Login to My account");
				System.out.println("3.Exit");
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice)
				{
					case 1:
							System.out.println("Enter name(First name-Middle name-Last name): ");
							String name = sc.nextLine();
							
							System.out.println("Enter phone number: ");
							String phone = sc.nextLine();
							System.out.println("Enter Ahdhaar number: ");
							String ad_no = sc.nextLine();
							System.out.println("Enter a Username: ");
							username = sc.nextLine();
							while(bank.stored.containsKey(username))
							{
								System.out.println("Username already exists.Please set again: ");
								username = sc.nextLine();
							}
							System.out.println("Set a password for your account");
							System.out.println("(must contain 8 chars at most;at most 3 numbers;atleast one special character(*&%$#)");
							password = sc.nextLine();
							while(!valid(password))
							{
								System.out.println("set a valid password!Set again:");
								password = sc.nextLine();
							}
							System.out.println("Enter initial balance: (1000 minimum)");
							amount = sc.nextDouble();
							while(amount < 1000)
							{
								System.out.println("Required initial balance is 1000.");
								amount = sc.nextDouble();
							}
							customer  = new User_account(name,phone,ad_no,username,password,amount,new Date());
							bank.stored.put(username, customer);
							System.out.println("Account registered successfully!Thank you for choosing us fro your service.");
							System.out.println("To do further more transactions please login with your username and password.");
							break;
					case 2:
							System.out.println("Enter a Username: ");
							username = sc.nextLine();
							
			           
						    if(bank.stored.containsKey(username))
							{
							    System.out.println("Enter your password: ");
								password = sc.nextLine();
								customer = bank.stored.get(username);
								if(customer.password.endsWith(password))
								{
									System.out.println("Welcome back "+" " + customer.name);
								    do
									{
								    	System.out.println("*MENU*");
								    	System.out.println("-------------------");
										System.out.println("1.Deposit amount");
										System.out.println("2.Withdraw amount");
										System.out.println("3.Check previous transactions");
										System.out.println("4.Logout from my account.");
										System.out.println("-------------------");
										System.out.println("Enter your choice: ");
										ch = sc.nextInt();
										sc.nextLine();
										switch(ch)
										{
											case 1:
													System.out.println("Enter amount to deposit: (500 minimum)");
													amount = sc.nextDouble();
													while(amount < 500)
													{
														System.out.println("Minimum amount should be 500");
														amount = sc.nextDouble();
													}
													customer.deposit(amount, new Date());
													System.out.println("Transaction complete!");
													break;
											case 2:
													System.out.println("Enter amount to withdraw: ");
													amount = sc.nextDouble();
													customer.withdraw(amount, new Date());
													System.out.println("Amount withdrew.Transaction complete!");
													break;
											case 3:
													System.out.println("Your last few transactions: ");
													for(String i: customer.transactions)
													{
														System.out.println(i);
													}
													System.out.println("Current balance: "+customer.balance);
													break;
											case 4:
												   System.out.println("Safely logged out .Thank you "+customer.name);
												   continue start;
											default:
													System.out.println("Enter a valid choice:");
								                    ch = sc.nextInt();
								                    sc.nextLine();
													break;
										}
									}while(ch < 4);
									
								}
								else
								{
									System.out.println("Incorrect password");
									System.out.println("Forgot password? : Please enter -YES/NO");
									String did = sc.nextLine();
									
									if(did.equalsIgnoreCase(yes))
									{
										System.out.println("Please enter your adhaar card number:");
										String check = sc.nextLine();
										if(customer.Adhaar_number.equals(check))
										{
											System.out.println("Enter a new password: ");
											System.out.println("Set a password for your account");
											System.out.println("(must contain 8 chars at most;at most 3 numbers;atleast one special character(*&%$#)");
											password = sc.nextLine();
											while(!valid(password))
											{
												System.out.println("set a valid password!");
												password = sc.nextLine();
											}
											customer.password = password;
											System.out.println("New password set!Login with your new username and password.");
										}
										else
										{
											System.out.println("You donnot have an account.");
										}
									}
									else
									{
										System.out.println("Please login again");
										
									}
									
								}
							}
							else
							{
								System.out.println("Account doesnot exist.Please create a account with our bank");
							}
							break;
					case 3: System.out.println("You have safely logged out.Thank you for interacting with us!");
					        break;
					default:
							System.out.println("Enter a valid choice: ");
							choice = sc.nextInt();
							sc.nextLine();
							break;
				}
			
		}while(choice < 3);
		sc.close();
	}
	
	public static boolean valid(String pass)
	{
	    int count=0;
	    int i=0;
	    boolean ans = false;
		if(pass.length() > 8)
		{
			return ans;
		}
		for( i=0;i<pass.length();++i)
		{
			if(Character.isDigit(pass.charAt(i)))
			{
				count++;
			}
		}
		if(count != 3)
		{
			ans= false;
		}
		else
		{
			for(i=0;i<pass.length();++i)
			{
				if(pass.charAt(i) == '#' || pass.charAt(i) == '$' || pass.charAt(i) == '*' || pass.charAt(i) == '&' || pass.charAt(i) == '%')
				{
					ans= true;
				}
			}
		}
		return ans;
		
	}
	
	

}


