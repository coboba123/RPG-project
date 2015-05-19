/**
 * 
 */

/**
 * @author Cody and Daniel
 *
 */
public class Weapon implements Item
{

	/* (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	
	private String myName;
	private int attValue;
	
	public Weapon(String name, int att)
	{
		myName = name;
		attValue = att;
	}
	
	public void setName(String name)
	{
		myName = name;
	}

	/* (non-Javadoc)
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}
	
	public int getAtt()
	{
		return attValue;
	}
	
	public void setAtt(int att)
	{
		attValue = att;
	}

}
