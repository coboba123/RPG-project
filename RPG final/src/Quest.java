/*
 * @author Daniel
 */

public class Quest 
{
	private String myName, myDesc;
	private double myReward;
	
	public Quest (String name, String desc, double reward)
	{
		myName = name;
		myDesc = desc;
		myReward = reward;
	}
	
	public void setName(String name)
	{
		myName = name;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public void setDesc(String desc)
	{
		myDesc = desc;
	}
	
	public String getDesc()
	{
		return myDesc;
	}
	
	public void setReward(double reward)
	{
		myReward = reward;
	}
	
	public double getReward()
	{
		return myReward;
	}
}
