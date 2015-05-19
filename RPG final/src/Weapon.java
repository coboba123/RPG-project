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
		// TODO Auto-generated method stub
		myName = name;
	}

	/* (non-Javadoc)
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return myName;
	}
	
	public int getAtt()
	{
		//TODO
		return attValue;
	}
	
	public void setAtt(int att)
	{
		attValue = att;
	}

}
