/**
 * 
 */

/**
 * @author Cody and Alex and Daniel
 *
 */
public class Armor implements Item
{

	/* (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	private String myName;
	private int defValue;
	
	@Override
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
	
	public int getDef()
	{
		// TODO
		return defValue;
	}
	
	public void setDef(int value)
	{
		//TODO
		defValue
	
	}

}
