/*
 * @author Daniel
 */

public class Money 
{
	private double myWallet;
	
	public Money()
	{
		myWallet = 0;
	}
	
	public Money(double num)
	{
		myWallet += num;
	}
	
	public void add(double num)
	{
		myWallet += num;
		if (myWallet > 1000)
		{
			myWallet = 1000;
		}
	}
	
	public void sub(double num)
	{
		myWallet -= num;
	}
	
	public double howMuch()
	{
		return myWallet;
	}
}
