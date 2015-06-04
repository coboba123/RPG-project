/**
 * @author Cody and Alex and Daniel
 */
public class Armor implements Item
{

	/*
	 * (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	private String myName;
	private int defValue;

	public Armor(String name, int def)
	{
		myName = name;
		defValue = def;
	}

	@Override
	public void setName(String name)
	{
		myName = name;
	}

	/*
	 * (non-Javadoc)
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}

	public int getDef()
	{
		return defValue;
	}

	public void setDef(int def)
	{
		defValue = def;

	}

}
