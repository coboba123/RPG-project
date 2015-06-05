/**
 * @author Cody and Daniel
 */
public class Weapon implements Item
{
	// name of weapon
	private String myName;

	// attack value of weapon
	private int attValue;

	// constructs weapon w/ name and attack
	public Weapon(String name, int att)
	{
		myName = name;
		attValue = att;
	}

	/**
	 * sets name of weapon
	 * 
	 * @param name: a String used to set the weapon's name
	 * 
	 * @see Item#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		myName = name;
	}

	/**
	 * gets the name of the weapon
	 * 
	 * @see Item#getName()
	 * 
	 * @returns name of weapon
	 */
	@Override
	public String getName()
	{
		return myName;
	}

	/** 
	 * gets the attack value of the weapon
	 * 
	 * @return attack value of weapon
	 */
	public int getAtt()
	{
		return attValue;
	}

	/**
	 *  sets attack value of weapon
	 * 
	 * @param att: The attack value you are setting the weapon to.
	 */
	public void setAtt(int att)
	{
		attValue = att;
	}
}
