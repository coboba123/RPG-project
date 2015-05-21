/**
 * @author Cody and Daniel
 *
 */
public class Weapon implements Item
{

	/* (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	
	//name of weapon
	private String myName;
	
	//description of weapon
	private String myDesc;
	//attack value of weapon
	private int attValue;
	
	//constructs weapon w/ name and attack
	public Weapon(String name, String desc, int att)
	{
		myName = name;
		myDesc = desc;
		attValue = att;
	}
	
	//sets name of weapon
	public void setName(String name)
	{
		myName = name;
	}

	/* 
	 * returns name of weapon
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}
	
	//returns attack value of weapon
	public int getAtt()
	{
		return attValue;
	}
	
	//sets attack value of weapon
	public void setAtt(int att)
	{
		attValue = att;
	}
	
	public String getDesc()
	{
		return myDesc;
	}
	
	public void setDesc(String desc)
	{
		myDesc = desc;
	}

}
